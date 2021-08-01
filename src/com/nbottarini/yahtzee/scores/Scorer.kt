package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Roll

interface Scorer {
    fun scoreFor(roll: Roll): Int
}
