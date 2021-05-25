package com.example.capstonemovie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.capstonemovie.databinding.ActivityMainBinding
import com.example.capstonemovie.movie.MovieFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mFragmentManager = supportFragmentManager
        val mHomeFragment = MovieFragment()
        val fragment = mFragmentManager.findFragmentByTag(MovieFragment::class.java.simpleName)
        if (fragment !is MovieFragment) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.main, mHomeFragment, MovieFragment::class.java.simpleName)
                .commit()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            val uri = Uri.parse("capstonemovie://favorite")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}