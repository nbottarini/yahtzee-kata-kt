package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class FourOfAKindScorer: Scorer {
    override fun scoreFor(roll: Roll) = roll.diceRepeatedAtLeast(4)?.times(4) ?: 0
}
