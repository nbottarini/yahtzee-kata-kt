package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class SameDiceScorer(private val dice: Int): Scorer {
    override fun scoreFor(roll: Roll) = roll.filter { it == dice }.sum()
}
