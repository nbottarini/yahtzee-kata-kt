package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class PairScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = highestPairDice(roll)?.times(2) ?: 0

    private fun highestPairDice(roll: Roll) = pairs(roll).maxOrNull()

    private fun pairs(roll: Roll) = roll.repeated(2)
}
