package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class ThreeOfAKindScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = roll.diceRepeatedAtLeast(3)?.times(3) ?: 0
}
