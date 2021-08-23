package model;

public class Dealer extends Player{

    private int otherPlayersHand;

    public Dealer() {
        super("dealer");
        this.otherPlayersHand = 0;
    }

    public void setPlayersAvgHand(int value){
        this.otherPlayersHand = value;
    }

    @Override
    public Boolean play() {
        return (this.getValueInHand()<=otherPlayersHand);
    }
}
