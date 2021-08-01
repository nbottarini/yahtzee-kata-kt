package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class LargeStraightScorer: Scorer {
    override fun scoreFor(roll: Roll) = if (isLargeStraight(roll)) 20 else 0

    private fun isLargeStraight(roll: Roll) = roll.toSet() == setOf(2, 3, 4, 5, 6)
}
