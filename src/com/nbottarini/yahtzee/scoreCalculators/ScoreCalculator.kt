package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

interface ScoreCalculator {
    fun scoreFor(roll: Roll): Int
}