package com.nbottarini.yahtzee.scores

import com.nbottarini.yahtzee.Categories
import com.nbottarini.yahtzee.Categories.*

class ScorerFactory {
    fun scorerFor(category: Categories) = when (category) {
        Ones -> SameDiceScorer(1)
        Twos -> SameDiceScorer(2)
        Threes -> SameDiceScorer(3)
        Fours -> SameDiceScorer(4)
        Fives -> SameDiceScorer(5)
        Sixes -> SameDiceScorer(6)
        Pair -> PairScorer()
        TwoPairs -> TwoPairsScorer()
        ThreeOfAKind -> ThreeOfAKindScorer()
        FourOfAKind -> FourOfAKindScorer()
        SmallStraight -> SmallStraightScorer()
        LargeStraight -> LargeStraightScorer()
        FullHouse -> FullHouseScorer()
        Yahtzee -> YahtzeeScorer()
        Chance -> ChanceScorer()
    }
}
