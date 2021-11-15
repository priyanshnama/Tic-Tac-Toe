package com.priyanshnama.tic_tac_toe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.priyanshnama.tic_tac_toe.databinding.ActivityHomeBinding
import com.priyanshnama.tic_tac_toe.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = FirebaseAuth.getInstance().currentUser
        Log.d("USER","name = ${user?.displayName}, email = ${user?.email}, uid = ${user?.uid}, photoUrl = ${user?.photoUrl}")
    }
}