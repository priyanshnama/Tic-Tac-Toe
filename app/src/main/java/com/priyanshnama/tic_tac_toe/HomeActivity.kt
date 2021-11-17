package com.priyanshnama.tic_tac_toe

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.priyanshnama.tic_tac_toe.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var currentPlayer: String = "X"
    private val choicesXO = arrayOf("", "", "", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = FirebaseAuth.getInstance().currentUser
        Log.d("USER","name = ${user?.displayName}, email = ${user?.email}, uid = ${user?.uid}, photoUrl = ${user?.photoUrl}")

        val gameButtons = listOf(binding.btnGame1, binding.btnGame2, binding.btnGame3,binding.btnGame4,
            binding.btnGame5,binding.btnGame6,binding.btnGame7,binding.btnGame8,binding.btnGame9)

        for (button in gameButtons) {
            button.setOnClickListener {
                updateBoard(it)
            }
        }
    }

    private fun updateBoard(view: View) {
        when(view.id) {
            binding.btnGame1.id -> if (binding.btnGame1.text.isEmpty()) {
                binding.btnGame1.text = currentPlayer
                choicesXO[1] = currentPlayer
                changePlayer()
            }
            binding.btnGame2.id -> if (binding.btnGame2.text.isEmpty()) {
                binding.btnGame2.text = currentPlayer
                choicesXO[2] = currentPlayer
                changePlayer()
            }
            binding.btnGame3.id -> if (binding.btnGame3.text.isEmpty()) {
                binding.btnGame3.text = currentPlayer
                choicesXO[3] = currentPlayer
                changePlayer()
            }
            binding.btnGame4.id -> if (binding.btnGame4.text.isEmpty()) {
                binding.btnGame4.text = currentPlayer
                choicesXO[4] = currentPlayer
                changePlayer()
            }
            binding.btnGame5.id -> if (binding.btnGame5.text.isEmpty()) {
                binding.btnGame5.text = currentPlayer
                choicesXO[5] = currentPlayer
                changePlayer()
            }
            binding.btnGame6.id -> if (binding.btnGame6.text.isEmpty()) {
                binding.btnGame6.text = currentPlayer
                choicesXO[6] = currentPlayer
                changePlayer()
            }
            binding.btnGame7.id -> if (binding.btnGame7.text.isEmpty()) {
                binding.btnGame7.text = currentPlayer
                choicesXO[7] = currentPlayer
                changePlayer()
            }
            binding.btnGame8.id -> if (binding.btnGame8.text.isEmpty()) {
                binding.btnGame8.text = currentPlayer
                choicesXO[8] = currentPlayer
                changePlayer()
            }
            else -> if (binding.btnGame9.text.isEmpty()) {
                binding.btnGame9.text = currentPlayer
                choicesXO[9] = currentPlayer
                changePlayer()
            }
        }
        checkWinner()
    }

    private fun checkWinner() {
    }

    private fun changePlayer() {
        currentPlayer = if (currentPlayer == "X") "O" else "X"
    }
}