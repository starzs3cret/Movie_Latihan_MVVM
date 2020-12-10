package id.unlink.movielatihanmvvm.ui.movielist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.unlink.movielatihanmvvm.MainActivity.Companion.API_KEY
import id.unlink.movielatihanmvvm.MainActivity.Companion.LANG
import id.unlink.movielatihanmvvm.MainActivity.Companion.PAGE
import id.unlink.movielatihanmvvm.R
import id.unlink.movielatihanmvvm.databinding.MovieListFragmentBinding
import id.unlink.movielatihanmvvm.model.MovieData
import id.unlink.movielatihanmvvm.model.Result
import id.unlink.movielatihanmvvm.recyclev.MovieAdapter
import id.unlink.movielatihanmvvm.retrofit.ApiService
import id.unlink.movielatihanmvvm.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }



    private lateinit var binding: MovieListFragmentBinding
    //view model
    private lateinit var viewModel: MovieListViewModel
    val list = ArrayList<Result>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.movie_list_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recy.setHasFixedSize(true)
        val listAdapter = MovieAdapter(list)
        listAdapter.notifyDataSetChanged()
        binding.recy.layoutManager = LinearLayoutManager(this.context)
        binding.recy.adapter = listAdapter
        // load data (moved to viewModel later)
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MovieListViewModel::class.java)
        viewModel.setPage(PAGE)
        viewModel.getMovie().observe(viewLifecycleOwner, Observer { movieItems->
            if(movieItems!=null){
                listAdapter.setData(movieItems)
                listAdapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }
        })
        // declare recy



    }



}