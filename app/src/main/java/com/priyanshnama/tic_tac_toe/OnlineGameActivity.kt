package com.priyanshnama.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.priyanshnama.tic_tac_toe.databinding.ActivityOnlineGameBinding

class OnlineGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnlineGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            // starts match based on game code
        }

        binding.btnGenerate.setOnClickListener {
            // generates game code which will be entered by other player
        }
    }
}