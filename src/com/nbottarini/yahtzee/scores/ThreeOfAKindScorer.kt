package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class ThreeOfAKindScorer: Scorer {
    override fun scoreFor(roll: Roll) = roll.diceRepeatedAtLeast(3)?.times(3) ?: 0
}
