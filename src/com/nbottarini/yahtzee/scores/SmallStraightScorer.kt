package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class SmallStraightScorer: Scorer {
    override fun scoreFor(roll: Roll) = if (isSmallStraight(roll)) 15 else 0

    private fun isSmallStraight(roll: Roll) = roll.toSet() == setOf(1, 2, 3, 4, 5)
}
