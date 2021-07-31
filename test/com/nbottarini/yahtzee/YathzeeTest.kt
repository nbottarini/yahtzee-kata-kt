package com.nbottarini.yahtzee

import com.nbottarini.yahtzee.Categories.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class YathzeeTest {
    @ParameterizedTest
    @CsvSource(
        "4|5|6|2|3, 20",
        "1|1|2|3|3, 10",
    )
    fun `chance score is the sum of all dices`(roll: String, score: Int) {
        assertThat(score(roll, Chance)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "1|1|2|2|3, 2",
        "3|4|2|2|3, 0",
    )
    fun `ones score is the sum of all ones`(roll: String, score: Int) {
        assertThat(score(roll, Ones)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "1|1|2|2|3, 4",
        "3|4|5|5|3, 0",
    )
    fun `twos score is the sum of all twos`(roll: String, score: Int) {
        assertThat(score(roll, Twos)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "1|3|2|2|3, 6",
        "6|4|5|5|6, 0",
    )
    fun `threes score is the sum of all threes`(roll: String, score: Int) {
        assertThat(score(roll, Threes)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "4|3|4|2|4, 12",
        "6|1|5|5|6, 0",
    )
    fun `fours score is the sum of all fours`(roll: String, score: Int) {
        assertThat(score(roll, Fours)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "5|3|5|2|5, 15",
        "6|1|3|2|6, 0",
    )
    fun `fives score is the sum of all fives`(roll: String, score: Int) {
        assertThat(score(roll, Fives)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "6|6|5|2|5, 12",
        "4|1|3|2|1, 0",
    )
    fun `sixes score is the sum of all sixes`(roll: String, score: Int) {
        assertThat(score(roll, Sixes)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|1|3|5, 4",
        "2|3|1|3|5, 6",
        "6|1|3|6|5, 12",
    )
    fun `pair score is the sum two matching dice`(roll: String, score: Int) {
        assertThat(score(roll, Pair)).isEqualTo(score)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2|6|1|3|5",
        "1|3|2|4|5",
    ])
    fun `pair score is 0 if no matching dice`(roll: String) {
        assertThat(score(roll, Pair)).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|3|3|5, 6",
        "6|3|6|3|5, 12",
    )
    fun `pair score is the sum the two highest matching dice`(roll: String, score: Int) {
        assertThat(score(roll, Pair)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|3|3|5, 10",
        "6|3|6|3|5, 18",
        "6|6|6|6|5, 24",
        "6|6|6|6|6, 24",
    )
    fun `twos pairs score is the sum the two pairs`(roll: String, score: Int) {
        assertThat(score(roll, TwoPairs)).isEqualTo(score)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2|6|2|3|5",
        "1|3|2|4|5",
        "2|2|3|4|5",
    ])
    fun `twos pairs score is 0 if there are no two pairs`(roll: String) {
        assertThat(score(roll, TwoPairs)).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|3|3|2, 6",
        "3|3|6|3|5, 9",
        "3|3|6|3|3, 9",
        "3|1|6|2|3, 0",
    )
    fun `three of a kind score is the sum the three matching dice`(roll: String, score: Int) {
        assertThat(score(roll, ThreeOfAKind)).isEqualTo(score)
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|2|3|2, 8",
        "1|1|1|1|5, 4",
        "5|5|5|5|5, 20",
        "3|1|3|2|3, 0",
    )
    fun `four of a kind score is the sum the four matching dice`(roll: String, score: Int) {
        assertThat(score(roll, FourOfAKind)).isEqualTo(score)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1|2|3|4|5",
        "5|4|3|2|1",
        "5|3|1|4|2",
    ])
    fun `small straight score is 15 if they read 1, 2, 3, 4, 5`(roll: String) {
        assertThat(score(roll, SmallStraight)).isEqualTo(15)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1|2|6|4|5",
        "5|3|3|2|1",
        "5|3|2|4|2",
    ])
    fun `small straight score is 0 if they don't read 1, 2, 3, 4, 5`(roll: String) {
        assertThat(score(roll, SmallStraight)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2|3|4|5|6",
        "6|5|4|3|2",
        "5|3|6|4|2",
    ])
    fun `large straight score is 25 if they read 2, 3, 4, 5, 6`(roll: String) {
        assertThat(score(roll, LargeStraight)).isEqualTo(20)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1|2|6|4|5",
        "5|3|3|2|6",
        "5|3|2|4|2",
    ])
    fun `large straight score is 0 if they don't read 2, 3, 4, 5, 6`(roll: String) {
        assertThat(score(roll, LargeStraight)).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "4|6|4|6|4, 24",
        "2|2|3|3|3, 13",
        "1|3|1|1|3, 9",
    )
    fun `full house score is the sum of all dices when there's a pair and a three of a kind`(roll: String, score: Int) {
        assertThat(score(roll, FullHouse)).isEqualTo(score)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "4|4|4|6|4",
            "2|1|3|3|3",
            "1|3|4|1|3",
        ]
    )
    fun `full house score is zero if not a full house`(roll: String) {
        assertThat(score(roll, FullHouse)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1|1|1|1|1",
            "2|2|2|2|2",
            "3|3|3|3|3",
            "4|4|4|4|4",
            "5|5|5|5|5",
            "6|6|6|6|6",
        ]
    )
    fun `yahtzee score is 50 if all dices are equal`(roll: String) {
        assertThat(score(roll, Yahtzee)).isEqualTo(50)
    }

    @Test
    fun `yahtzee score is 0 if not all dices are equal`() {
        assertThat(score("2|2|4|2|2", Yahtzee)).isEqualTo(0)
    }

    private fun score(roll: String, category: Categories) = Yahtzee().calculateScore(Roll.fromString(roll), category)
}