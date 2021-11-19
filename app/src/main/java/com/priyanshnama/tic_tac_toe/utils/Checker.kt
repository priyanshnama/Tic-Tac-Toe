package com.priyanshnama.tic_tac_toe.utils

import kotlin.math.abs

class Checker {
    suspend fun checkBoard(data: Array<Int>): String {
        when {
            abs(data[0] + data[1] + data[2]) == 3 -> return mask(data[0])
            abs(data[3] + data[4] + data[5]) == 3 -> return mask(data[3])
            abs(data[6] + data[7] + data[8]) == 3 -> return mask(data[6])
            abs(data[0] + data[3] + data[6]) == 3 -> return mask(data[0])
            abs(data[1] + data[4] + data[7]) == 3 -> return mask(data[1])
            abs(data[2] + data[5] + data[8]) == 3 -> return mask(data[2])
            abs(data[0] + data[4] + data[8]) == 3 -> return mask(data[0])
            abs(data[2] + data[4] + data[6]) == 3 -> return mask(data[2])
        }
        return "none"
    }

    private fun mask(currentPlayer: Int): String {
        return if(currentPlayer==1) "X"
        else "O"
    }
}