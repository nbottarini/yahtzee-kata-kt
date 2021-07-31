package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class TwoPairsScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = if (pairs(roll).size == 4) pairs(roll).sum() else 0

    private fun pairs(roll: Roll) = roll.repeated(2) + roll.repeated(4) + roll.repeated(5).drop(1)
}
