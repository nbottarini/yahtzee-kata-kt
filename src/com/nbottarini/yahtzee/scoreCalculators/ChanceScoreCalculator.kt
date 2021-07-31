package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Roll

class ChanceScoreCalculator: ScoreCalculator {
    override fun scoreFor(roll: Roll) = roll.sum()
}
