package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class FourOfAKindScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = roll.diceRepeatedAtLeast(4)?.times(4) ?: 0
}
