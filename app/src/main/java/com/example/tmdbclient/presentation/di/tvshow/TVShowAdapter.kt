package com.example.tmdbclient.presentation.di.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.data.model.tv.TVShowList
import com.example.tmdbclient.databinding.TvShowListItemBinding

class TVShowAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TVShow>()
    fun setList(tvShows:List<TVShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:TvShowListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.tv_show_list_item,
            parent,false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class MyViewHolder(val binding: TvShowListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TVShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        binding.firstAirTextView.text = tvShow.firstAirDate
        val posterURL ="https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}