package com.example.tmdbclient.presentation.tv_show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tvshow)
    }
}