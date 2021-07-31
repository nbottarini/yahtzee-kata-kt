package com.nbottarini.yahtzee

class Roll(vararg dices: Int): List<Int> by dices.toList() {
    constructor(dices: List<Int>): this(*dices.toIntArray())

    init {
        if (dices.size != 5) throw InvalidRollError()
        if (dices.any { it < 1 || it > 6 }) throw InvalidRollError()
    }

    fun repeated(times: Int) = filter { dice -> count { it == dice } == times }

    fun repeatedAtLeast(times: Int) = filter { dice -> count { it == dice } >= times }

    fun diceRepeatedAtLeast(times: Int) = repeatedAtLeast(times).distinct().firstOrNull()

    companion object {
        fun fromString(roll: String) = Roll(roll.split("|").map { it.toInt() })
    }
}
