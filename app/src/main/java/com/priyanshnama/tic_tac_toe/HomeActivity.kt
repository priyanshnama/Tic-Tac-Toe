package com.priyanshnama.tic_tac_toe

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.priyanshnama.tic_tac_toe.utils.Checker
import com.priyanshnama.tic_tac_toe.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var currentPlayer: Int = 1
    private lateinit var checker:Checker
    private lateinit var gameButtons : List<TextView>
    private var choicesXO = arrayOf(0,0,0,0,0,0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checker = Checker()

        val user = FirebaseAuth.getInstance().currentUser
        Log.d("USER","name = ${user?.displayName}, email = ${user?.email}, uid = ${user?.uid}, photoUrl = ${user?.photoUrl}")

        gameButtons = listOf(binding.btnGame1, binding.btnGame2, binding.btnGame3,binding.btnGame4,
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
                binding.btnGame1.text = mask(currentPlayer)
                choicesXO[0] = currentPlayer
            }
            binding.btnGame2.id -> if (binding.btnGame2.text.isEmpty()) {
                binding.btnGame2.text = mask(currentPlayer)
                choicesXO[1] = currentPlayer
            }
            binding.btnGame3.id -> if (binding.btnGame3.text.isEmpty()) {
                binding.btnGame3.text = mask(currentPlayer)
                choicesXO[2] = currentPlayer
            }
            binding.btnGame4.id -> if (binding.btnGame4.text.isEmpty()) {
                binding.btnGame4.text = mask(currentPlayer)
                choicesXO[3] = currentPlayer
            }
            binding.btnGame5.id -> if (binding.btnGame5.text.isEmpty()) {
                binding.btnGame5.text = mask(currentPlayer)
                choicesXO[4] = currentPlayer
            }
            binding.btnGame6.id -> if (binding.btnGame6.text.isEmpty()) {
                binding.btnGame6.text = mask(currentPlayer)
                choicesXO[5] = currentPlayer
            }
            binding.btnGame7.id -> if (binding.btnGame7.text.isEmpty()) {
                binding.btnGame7.text = mask(currentPlayer)
                choicesXO[6] = currentPlayer
            }
            binding.btnGame8.id -> if (binding.btnGame8.text.isEmpty()) {
                binding.btnGame8.text = mask(currentPlayer)
                choicesXO[7] = currentPlayer
            }
            binding.btnGame9.id -> if (binding.btnGame9.text.isEmpty()) {
                binding.btnGame9.text = mask(currentPlayer)
                choicesXO[8] = currentPlayer
            }
        }
        changePlayer()
        val winner = checker.checkBoard(choicesXO)
        if(winner!="none") showDialog(winner)
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.winner_dialog)
        val body = dialog.findViewById(R.id.body) as TextView
        body.text = "$title wins"
        val okBtn = dialog.findViewById(R.id.ok) as Button
        okBtn.setOnClickListener {
            dialog.dismiss()
            for(button in gameButtons) button.text=""
            choicesXO = arrayOf(0,0,0,0,0,0,0,0,0)
        }
        dialog.show()
    }

    private fun mask(currentPlayer: Int): CharSequence {
        return if(currentPlayer==1) "X"
        else "O"
    }

    private fun changePlayer() {
        currentPlayer = if (currentPlayer == 1) -1 else 1
    }
}