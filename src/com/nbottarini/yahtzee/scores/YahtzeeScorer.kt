package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

class YahtzeeScorer: Scorer {
    override fun scoreFor(roll: Roll) = if (isYahtzee(roll)) 50 else 0

    private fun isYahtzee(roll: Roll) = allEquals(roll)

    private fun allEquals(roll: Roll) = roll.distinct().size == 1
}
