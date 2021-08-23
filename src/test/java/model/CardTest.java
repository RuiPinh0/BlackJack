package model;

import enums.Suit;
import enums.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card card;

    @Test
    void getValue() {
       this.card =  new Card(Suit.S, Value.ACE);
       assertEquals(this.card.getValue(), Value.ACE.getValue());
       assertNotEquals(this.card.getValue(), Value.TWO.getValue());
    }

    @Test
    void testToString() {
        this.card =  new Card(Suit.H, Value.ACE);
        assertEquals(this.card.toString(), (Suit.H.toString() + Value.ACE));
        assertNotEquals(this.card.toString(), (Suit.H.toString() + Value.QUEEN));
        assertNotEquals(this.card.toString(), (Suit.S.toString() + Value.QUEEN));
    }
}