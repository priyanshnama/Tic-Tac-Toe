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
import com.priyanshnama.tic_tac_toe.databinding.ActivityHomeBinding
import com.priyanshnama.tic_tac_toe.utils.Checker
import kotlinx.coroutines.*

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private var currentPlayer: Int = 1
    private var moves: Int = 0
    private lateinit var checker: Checker
    private lateinit var gameButtons: List<TextView>
    private var choicesXO = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        checker = Checker()

        val user = FirebaseAuth.getInstance().currentUser
        Log.d(
            "USER",
            "name = ${user?.displayName}, email = ${user?.email}, uid = ${user?.uid}, photoUrl = ${user?.photoUrl}"
        )

        gameButtons = listOf(
            activityHomeBinding.btnGame1, activityHomeBinding.btnGame2, activityHomeBinding.btnGame3, activityHomeBinding.btnGame4,
            activityHomeBinding.btnGame5, activityHomeBinding.btnGame6, activityHomeBinding.btnGame7, activityHomeBinding.btnGame8, activityHomeBinding.btnGame9
        )

        for (button in gameButtons) {
            button.setOnClickListener {
                updateBoard(it)
            }
        }
    }

    private fun updateBoard(view: View) {
        when (view.id) {
            activityHomeBinding.btnGame1.id -> if (activityHomeBinding.btnGame1.text.isEmpty()) {
                activityHomeBinding.btnGame1.text = mask(currentPlayer)
                choicesXO[0] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame2.id -> if (activityHomeBinding.btnGame2.text.isEmpty()) {
                activityHomeBinding.btnGame2.text = mask(currentPlayer)
                choicesXO[1] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame3.id -> if (activityHomeBinding.btnGame3.text.isEmpty()) {
                activityHomeBinding.btnGame3.text = mask(currentPlayer)
                choicesXO[2] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame4.id -> if (activityHomeBinding.btnGame4.text.isEmpty()) {
                activityHomeBinding.btnGame4.text = mask(currentPlayer)
                choicesXO[3] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame5.id -> if (activityHomeBinding.btnGame5.text.isEmpty()) {
                activityHomeBinding.btnGame5.text = mask(currentPlayer)
                choicesXO[4] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame6.id -> if (activityHomeBinding.btnGame6.text.isEmpty()) {
                activityHomeBinding.btnGame6.text = mask(currentPlayer)
                choicesXO[5] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame7.id -> if (activityHomeBinding.btnGame7.text.isEmpty()) {
                activityHomeBinding.btnGame7.text = mask(currentPlayer)
                choicesXO[6] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame8.id -> if (activityHomeBinding.btnGame8.text.isEmpty()) {
                activityHomeBinding.btnGame8.text = mask(currentPlayer)
                choicesXO[7] = currentPlayer
                changePlayer()
            }
            activityHomeBinding.btnGame9.id -> if (activityHomeBinding.btnGame9.text.isEmpty()) {
                activityHomeBinding.btnGame9.text = mask(currentPlayer)
                choicesXO[8] = currentPlayer
                changePlayer()
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            val winner = checker.checkBoard(choicesXO)
            withContext(Dispatchers.Main) {
                if (winner != "none") showDialog("$winner wins")
                if (winner == "none" && moves == 9) showDialog("Draw")
            }
        }
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.winner_dialog)
        val body = dialog.findViewById(R.id.body) as TextView
        body.text = title
        val okBtn = dialog.findViewById(R.id.ok) as Button
        okBtn.setOnClickListener {
            dialog.dismiss()
            for (button in gameButtons) button.text = ""
            choicesXO = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
            moves = 0
        }
        dialog.show()
    }

    private fun mask(currentPlayer: Int): CharSequence {
        return if (currentPlayer == 1) "X"
        else "O"
    }

    private fun changePlayer() {
        moves++
        activityHomeBinding.rightArrow.rotation = 90.0F * (1 + currentPlayer)
        currentPlayer = if (currentPlayer == 1) -1 else 1
    }
}