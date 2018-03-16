package com.company.test;

import com.company.main.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = Game.getInstance();
    }

    @Test
    public void askOpponentReal_successfullySetsWhetherOpponentIsRealOrNot() {

        game.askOpponentReal("computer");
        assertEquals(game.isOpponentReal(), false);

        game.askOpponentReal("person");
        assertEquals(game.isOpponentReal(), true);

        game.askOpponentReal("Computer");
        assertEquals(game.isOpponentReal(), false);

        game.askOpponentReal("Person");
        assertEquals(game.isOpponentReal(), true);

        game.askOpponentReal("COMPUTER");
        assertEquals(game.isOpponentReal(), false);

        game.askOpponentReal("PERSON");
        assertEquals(game.isOpponentReal(), true);

        game.askOpponentReal("cOmPuTeR");
        assertEquals(game.isOpponentReal(), false);

        game.askOpponentReal("PeRsOn");
        assertEquals(game.isOpponentReal(), true);

    }

    @Test
    public void createPlayers_createsPlayersAndSetsNamesCorrectly() {

        game.askOpponentReal("Person");
        game.createPlayers("test1", "test2");
        assertEquals(game.isOpponentReal(), true);
        assertEquals(game.player1.getName(), "test1");
        assertEquals(game.player2.getName(), "test2");

        game.askOpponentReal("Computer");
        game.createPlayers("test1");
        assertEquals(game.isOpponentReal(), false);
        assertEquals(game.player1.getName(), "test1");

    }

    @Test
    public void askChoices_setsChoiceSuccessfully() {

        game.askOpponentReal("Person");
        game.createPlayers("test1", "test2");
        game.createChoices("rock", "paper");
        assertEquals(game.isOpponentReal(), true);
        assertEquals(game.player1.getName(), "test1");
        assertEquals(game.player2.getName(), "test2");
        assertEquals(game.player1.getChoice(), "rock");
        assertEquals(game.player2.getChoice(), "paper");

        game.askOpponentReal("Computer");
        game.createPlayers("test1");
        game.createChoices("scissors");
        assertEquals(game.isOpponentReal(), false);
        assertEquals(game.player1.getName(), "test1");
        assertEquals(game.player1.getChoice(), "scissors");
        System.out.println(game.computer.getChoice());

    }

    @Test
    public void chooseWinner_choosesCorrectWinner() {

        game.chooseWinningSide("rock", "scissors");
        assertEquals(game.getWinner(), 1);
        game.chooseWinningSide("rock", "paper");
        assertEquals(game.getWinner(), 2);
        game.chooseWinningSide("rock", "rock");
        assertEquals(game.getWinner(), 3);
        game.chooseWinningSide("paper", "scissors");
        assertEquals(game.getWinner(), 2);
        game.chooseWinningSide("paper", "paper");
        assertEquals(game.getWinner(), 3);
        game.chooseWinningSide("paper", "rock");
        assertEquals(game.getWinner(), 1);
        game.chooseWinningSide("scissors", "scissors");
        assertEquals(game.getWinner(), 3);
        game.chooseWinningSide("scissors", "paper");
        assertEquals(game.getWinner(), 1);
        game.chooseWinningSide("scissors", "rock");
        assertEquals(game.getWinner(), 2);

    }

}
