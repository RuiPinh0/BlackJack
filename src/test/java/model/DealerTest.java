package model;

import enums.Suit;
import enums.Value;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest{

    private Dealer dealer;

    private DealerTest() {
        this.dealer = new Dealer();
    }

    @Test
    void setPlayersAvgHand() {
        this.dealer.setPlayersAvgHand(16);
        this.dealer.addCard(new Card(Suit.S, Value.ACE));
        this.dealer.addCard(new Card(Suit.S, Value.FIVE));
        assertTrue(this.dealer.play());
        this.dealer.addCard(new Card(Suit.H, Value.FIVE));
        assertFalse(this.dealer.play());
    }

    @Test
    void testPlay() {
        this.dealer.addCard(new Card(Suit.S, Value.ACE));
        this.dealer.addCard(new Card(Suit.C, Value.THREE));
        this.dealer.setPlayersAvgHand(16);
        assertTrue(this.dealer.play());

        this.dealer.addCard(new Card(Suit.C, Value.FIVE));
        assertFalse(this.dealer.play());

        this.dealer.setPlayersAvgHand(20);
        assertTrue(this.dealer.play());
    }
}