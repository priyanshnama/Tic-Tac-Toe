package com.priyanshnama.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.priyanshnama.tic_tac_toe.databinding.ActivityGameModeBinding

class GameModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOffline.setOnClickListener {
            val intent = Intent(this@GameModeActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnOnline.setOnClickListener {

        }
    }
}