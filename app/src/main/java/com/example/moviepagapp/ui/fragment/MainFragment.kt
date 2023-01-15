package com.example.moviepagapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.moviepagapp.R
import com.example.moviepagapp.databinding.FragmentMainBinding
import com.example.moviepagapp.models.Movie

import com.example.moviepagapp.ui.adapter.MovieAdapter
import com.example.moviepagapp.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment() : Fragment(),SearchView.OnQueryTextListener {
         private lateinit var binding: FragmentMainBinding
        private lateinit var mAdapter: MovieAdapter
        private val viewModel : MoviesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        setuprv()
        loadingData()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        requireActivity().addMenuProvider(object  : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
               return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        viewModel.movieListLiveData.observe(viewLifecycleOwner){

        }




        return binding.root
    }

    private fun loadingData(){

        lifecycleScope.launch{
            viewModel.listData.collect{ PagingData ->

             mAdapter.submitData(PagingData)


            }
        }

    }


    private fun setuprv(){
        mAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            binding.switchGrid.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    layoutManager = LinearLayoutManager(requireContext())
                else

                layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            }




            adapter=mAdapter
            setHasFixedSize(true)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    fun movieAddLocalDb(title : String){

    }


}