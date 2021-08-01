package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class ChanceScorer: Scorer {
    override fun scoreFor(roll: Roll) = roll.sum()
}
