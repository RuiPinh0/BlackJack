package model;

import enums.Suit;
import enums.Value;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value.getValue();
    }

    @Override
    public String toString() {
        return "" + suit + value;
    }
}
