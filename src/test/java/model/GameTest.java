package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;


    @Test
    void run() {
        game=new Game();
        assertNotNull(game.run(null));
        assertNotEquals("", game.run(null));
    }

}