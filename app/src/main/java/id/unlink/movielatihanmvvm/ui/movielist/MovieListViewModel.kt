package id.unlink.movielatihanmvvm.ui.movielist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import id.unlink.movielatihanmvvm.MainActivity
import id.unlink.movielatihanmvvm.MainActivity.Companion.TAG
import id.unlink.movielatihanmvvm.model.MovieData
import id.unlink.movielatihanmvvm.model.Result
import id.unlink.movielatihanmvvm.recyclev.MovieAdapter
import id.unlink.movielatihanmvvm.retrofit.ApiService
import id.unlink.movielatihanmvvm.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val listMovie = MutableLiveData<ArrayList<Result>>()
    private  lateinit var mApiService: ApiService

    fun setPage(page:Int){
        // disini get data retrofit
        loadMovie(page)
    }
    fun getMovie(): LiveData<ArrayList<Result>>{
        return listMovie
    }

    private fun loadMovie(page: Int) {
        mApiService= ApiUtils.apiService
        mApiService.getMovieData(MainActivity.API_KEY, MainActivity.LANG, page)
            .enqueue(object : Callback<MovieData> {
                override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                    if (response.code() == 200) {
                        //
                        response.body()?.let { buildResponse(it) }
                    }
                }

                override fun onFailure(call: Call<MovieData>, t: Throwable) {
                    Log.e(TAG, "onFailure: ",t )
                }

            })

    }

    private fun buildResponse(movieResponse: MovieData) {
        val list = ArrayList<Result>()
        for (resulte in movieResponse.results){
            val movie: Result = resulte
            list.add(movie)
        }
        // post value
        listMovie.postValue(list)


    }
}