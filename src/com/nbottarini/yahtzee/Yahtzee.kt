package com.nbottarini.yahtzee

import com.nbottarini.yahtzee.scoreCalculators.ScoreCalculatorFactory

class Yahtzee {
    private val factory = ScoreCalculatorFactory()

    fun calculateScore(roll: Roll, category: Categories) = factory.scoreCalculatorFor(category).scoreFor(roll)
}
