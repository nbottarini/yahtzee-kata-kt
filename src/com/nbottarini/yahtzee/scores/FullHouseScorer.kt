package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class FullHouseScorer : Scorer {
    override fun scoreFor(roll: Roll) = if (isFullHouse(roll)) roll.sum() else 0

    private fun isFullHouse(roll: Roll) = pairs(roll).size == 2 && threesOfAKind(roll).size == 3

    private fun threesOfAKind(roll: Roll) = roll.repeated(3)

    private fun pairs(roll: Roll) = roll.repeated(2)
}
