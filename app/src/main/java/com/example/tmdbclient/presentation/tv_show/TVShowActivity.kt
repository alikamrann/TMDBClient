package com.example.tmdbclient.presentation.tv_show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvshowBinding
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.tvshow.TVShowAdapter
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var adapter: TVShowAdapter

    private lateinit var binding: ActivityTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        (application as Injector).createTVShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShow()

    }

    private fun displayPopularTvShow() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTVShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    private fun updateMovies() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTVShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}