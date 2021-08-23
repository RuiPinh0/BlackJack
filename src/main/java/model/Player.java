package model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Actions {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        cards = new LinkedList<>();
    }

    public int getValueInHand(){
        return cards.stream().mapToInt(Card::getValue).sum();
    }

    @Override
    public Boolean isBlackJack() {
        if(this.getValueInHand() == 21){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean play() {
        return getValueInHand()<17;
    }

    @Override
    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return "" + name +
                ": " +
                cards.stream().map(Card::toString).collect(Collectors.joining(", "));
    }
}
