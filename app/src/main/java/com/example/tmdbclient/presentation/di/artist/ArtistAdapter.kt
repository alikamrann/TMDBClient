package com.example.tmdbclient.presentation.di.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.databinding.ArtistListItemBinding

class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artist:List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ArtistListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.artist_list_item,
            parent,false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}

class MyViewHolder(val binding: ArtistListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        val posterURL ="https://image.tmdb.org/t/p/w500/"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}