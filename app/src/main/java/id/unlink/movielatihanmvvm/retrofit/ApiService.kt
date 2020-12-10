package id.unlink.movielatihanmvvm.retrofit

import id.unlink.movielatihanmvvm.model.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://api.themoviedb.org/3/movie/upcoming?api_key=eceaa905c234957caf0e25e78774f588&language=en-US&page=1
    @GET("3/movie/upcoming?")
    fun getMovieData(@Query("api_key")api_key:String,
                     @Query("language")language:String,
                     @Query("page")page:Int): Call<MovieData>
}