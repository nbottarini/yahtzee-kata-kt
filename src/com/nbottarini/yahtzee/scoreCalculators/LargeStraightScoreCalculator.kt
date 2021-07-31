package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class LargeStraightScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = if (isLargeStraight(roll)) 20 else 0

    private fun isLargeStraight(roll: Roll) = roll.toSet() == setOf(2, 3, 4, 5, 6)
}
