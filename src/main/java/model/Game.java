package model;

import enums.Suit;
import enums.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Actions> playersList;
    private Dealer dealer;
    private List<Card> deck;
    private List<String> winners;

    public Game() {
        this.playersList = new LinkedList<>();
        this.playersList.add(new Player("Sam"));
        this.dealer = new Dealer();
        this.deck = new LinkedList<>();
        this.winners = new LinkedList<>();
    }
    
    public String run(String path){
        int playersOut = 0;

        loadDeck(path);
        giveCards();
        validateHands();

        if(winners.size()!=0 && (winners.size() == playersList.size() || winners.get(0).equals(dealer.getName()))){
            return winners.toString(); //winners
        }

        for (Actions player : playersList) {
            while (player.play()){
                getCard(player);
                if(player.isBlackJack()){
                    winners.add(player.getName());
                };
            }
            if (player.getValueInHand()>21){
                playersOut++;
            }
        }

        if(playersOut == playersList.size()) return dealer.getName();
        if(winners.size() == playersList.size()) return winners.toString();

        dealer.setPlayersAvgHand(playersList.stream().mapToInt(Actions::getValueInHand).sum()/playersList.size()); //not good for more than 1 player

        while (dealer.play()){
            getCard(dealer);
            if(dealer.isBlackJack()){
                return dealer.getName();//dealer win
            };
        }
        if (dealer.getValueInHand()>=21){
            return playersList.stream()
                    .filter(player -> player.getValueInHand() <= 21)
                    .map(Actions::getName)
                    .collect(Collectors.toList())
                    .toString();//dealer lose
        }
        return dealer.getName();
    }

    private void validateHands() {

        for (Actions player : playersList) {
            if (player.isBlackJack()) winners.add(player.getName());
        }

        if (winners.size() > 0) return;

        if(dealer.isBlackJack()) {
            winners.add(dealer.getName());
            return;

        }
        if(dealer.getValueInHand() == 22 && playersList.get(0).getValueInHand()==22 && playersList.size()==1){
            winners.add(dealer.getName());
        }
    }

    private void giveCards() {
        for (int i = 1; i <= 2; i++){
            for (Actions player : playersList) {
                getCard(player);

            }
            getCard(dealer);
        }
    }

    private void getCard(Actions player) {
        player.addCard(deck.get(0));
        deck.remove(0);
    }

    private void loadDeck(String path) {
        if (path != null){
            String [] deckFromFile = loadFromFile(path);
            for(String s : deckFromFile){
                Suit suit = Suit.valueOf(String.valueOf((s.charAt(0))));
                for (Value v : Value.values()){
                    if(v.toString().equals(String.valueOf(s.charAt(1)))){
                        deck.add(new Card(suit, v));
                    }
                }
            }
        }else{
            for(Suit suit : Suit.values()){
                for(Value value : Value.values()){
                    deck.add(new Card(suit, value));
                }
            }
            Collections.shuffle(deck);
        }
    }

    private String[] loadFromFile(String path) {
        try(BufferedReader in = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] tokens = str.split(", ");
                return tokens;
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
        return null;
    }

    public void printResults(){
        for(Actions action : playersList){
            System.out.println(action.toString());
        }
        System.out.println(dealer.toString());
    }
}
