package com.nbottarini.yahtzee.scoreCalculators

import com.nbottarini.yahtzee.Categories
import com.nbottarini.yahtzee.Categories.*

class ScoreCalculatorFactory {
    fun scoreCalculatorFor(category: Categories) = when (category) {
        Ones -> SameDiceScoreCalculator(1)
        Twos -> SameDiceScoreCalculator(2)
        Threes -> SameDiceScoreCalculator(3)
        Fours -> SameDiceScoreCalculator(4)
        Fives -> SameDiceScoreCalculator(5)
        Sixes -> SameDiceScoreCalculator(6)
        Pair -> PairScoreCalculator()
        TwoPairs -> TwoPairsScoreCalculator()
        ThreeOfAKind -> ThreeOfAKindScoreCalculator()
        FourOfAKind -> FourOfAKindScoreCalculator()
        SmallStraight -> SmallStraightScoreCalculator()
        LargeStraight -> LargeStraightScoreCalculator()
        FullHouse -> FullHouseScoreCalculator()
        Yahtzee -> YahtzeeScoreCalculator()
        Chance -> ChanceScoreCalculator()
    }
}
