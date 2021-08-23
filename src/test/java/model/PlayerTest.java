package model;

import enums.Suit;
import enums.Value;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final String SAM = "sam";
    private Player player;

    private PlayerTest() {
        player = new Player(SAM);
    }

    @Test
    void testGetValueInHand() {
        this.player.addCard(new Card(Suit.S, Value.ACE));
        assertEquals(11, this.player.getValueInHand());
        assertNotEquals(9, this.player.getValueInHand());
        this.player.addCard(new Card(Suit.D, Value.QUEEN));
        assertEquals(21, this.player.getValueInHand());
        assertNotEquals(20, this.player.getValueInHand());
        assertTrue(this.player.isBlackJack());

    }

    @Test
    void testIsBlackJack() {
        this.player.addCard(new Card(Suit.S, Value.ACE));
        assertFalse(this.player.isBlackJack());
        this.player.addCard(new Card(Suit.D, Value.QUEEN));
        assertTrue(this.player.isBlackJack());
    }

    @Test
    void testGetName() {
        assertEquals(SAM, this.player.getName());
        assertNotEquals("Eddie", this.player.getName());
        assertNotNull(this.player.getName());
    }

    @Test
    void testPlay() {
        this.player.addCard(new Card(Suit.S, Value.ACE));
        this.player.addCard(new Card(Suit.H, Value.TWO));
        assertTrue(this.player.play());
        this.player.addCard(new Card(Suit.D, Value.NINE));
        assertFalse(this.player.play());
    }

    @Test
    void testAddCard() {
        this.player.addCard(new Card(Suit.S, Value.ACE));
        assertEquals(11, this.player.getValueInHand());
        assertNotEquals(9, this.player.getValueInHand());
    }

    @Test
    void testToString() {
        assertNotNull(this.player.toString());
    }
}