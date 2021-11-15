package com.priyanshnama.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.priyanshnama.tic_tac_toe.databinding.ActivityHomeBinding
import com.priyanshnama.tic_tac_toe.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}