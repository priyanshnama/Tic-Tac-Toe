package com.priyanshnama.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.priyanshnama.tic_tac_toe.databinding.ActivityGameModeBinding

class GameModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOffline.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("mode","offline")
            startActivity(intent)
        }

        binding.btnOnline.setOnClickListener {
            binding.askMode.visibility = View.GONE
            binding.askJoin.visibility = View.VISIBLE
        }
    }
}