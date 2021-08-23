package model;

public interface Actions {
    String getName();
    int getValueInHand();
    Boolean play();
    Boolean isBlackJack();
    void addCard(Card card);
}
