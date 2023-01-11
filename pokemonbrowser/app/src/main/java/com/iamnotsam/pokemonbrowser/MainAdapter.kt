package com.iamnotsam.pokemonbrowser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamnotsam.pokemonbrowser.databinding.AdapterMovieBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var movies = mutableListOf<Card>()

    fun setMovieList(movies: List<Card>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
       holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.images[0]).into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
