package com.company.main;

public class Main {

    private static boolean fullGame = true;
    private static boolean singleGame = true;

    public static void main(String[] args) {

	    Game game = Game.getInstance();
	    do {
            setSingleGame(true);
	        game.mainMenu();
            game.askOpponentReal();
            game.createPlayers();
            do {
                game.createChoices();
                game.chooseWinner();
            } while (Main.singleGame);
	    } while (Main.fullGame);
    }

    static void setFullGame() {
        Main.fullGame = false;
    }

    static void setSingleGame(boolean singleGame) {
        Main.singleGame = singleGame;
    }

}
