package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class SameDiceScoreCalculator(private val dice: Int): ScoreCalculator {
    override fun scoreFor(roll: Roll) = roll.filter { it == dice }.sum()
}
