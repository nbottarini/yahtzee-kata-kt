package com.nbottarini.yahtzee

import com.nbottarini.yahtzee.scores.ScorerFactory

class Yahtzee {
    private val factory = ScorerFactory()

    fun calculateScore(roll: Roll, category: Categories) = factory.scorerFor(category).scoreFor(roll)
}
