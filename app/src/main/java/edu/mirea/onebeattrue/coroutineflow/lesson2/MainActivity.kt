package edu.mirea.onebeattrue.coroutineflow.lesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.mirea.onebeattrue.coroutineflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonUsersActivity.setOnClickListener {
            startActivity(UsersActivity.newIntent(this))
        }
    }
}