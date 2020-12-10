package id.unlink.movielatihanmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import id.unlink.movielatihanmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.nav_fragment))
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

    companion object{
        val BASE_URL = "https://api.themoviedb.org/"
        val API_KEY = "replace with you API_KEY"
        val LANG = "en-US" // id-ID for indonesia
        val PAGE = 1 // next button add it
        val IMG_URL_PRE = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"
        val TAG = "MovieFragment"
    }
}
