package id.unlink.movielatihanmvvm.recyclev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.unlink.movielatihanmvvm.MainActivity.Companion.IMG_URL_PRE
import id.unlink.movielatihanmvvm.R
import id.unlink.movielatihanmvvm.model.Result



class MovieAdapter(private val listMovie:ArrayList<Result>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    fun setData(items:ArrayList<Result>){
        listMovie.clear()
        listMovie.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_movie,parent,false)
        return MovieViewHolder(view)
    }


    override fun getItemCount(): Int =listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result:Result){
            with(itemView){
                Glide.with(itemView.context)
                    .load(IMG_URL_PRE+result.poster_path)
                    .apply(RequestOptions().override(66,118))
                    .into(itemView.findViewById(R.id.imPoster))
                itemView.findViewById<TextView>(R.id.txTitle).text=result.title
                itemView.findViewById<TextView>(R.id.txDesc).text=result.overview
            }
        }
    }


}