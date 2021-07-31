package com.nbottarini.yahtzee

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RollTest {
    @Test
    fun `fail if more than 5 dices`() {
        assertThrows<InvalidRollError> { Roll(1, 2, 3, 4, 5, 6) }
    }

    @Test
    fun `fail if less than 5 dices`() {
        assertThrows<InvalidRollError> { Roll(1, 2, 3, 4) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1|2|7|4|5",
        "7|2|1|4|5",
        "1|2|1|9|5",
        "0|2|1|9|5",
        "0|2|3|9|-5",
    ])
    fun `fail if dices not between 1 and 6`(roll: String) {
        assertThrows<InvalidRollError> { Roll.fromString(roll) }
    }
}
