package com.company.main;

import java.util.Scanner;

import static com.company.main.Main.*;

public class Game {

    private static Game game = null;
    private boolean opponentReal = false;
    public static Scanner scanner  = new Scanner(System.in);
    private static PastGames pastGames = new PastGames();
    public Player player1;
    public Player player2;
    public Computer computer;
    private int winner;

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public boolean isOpponentReal() {
        return opponentReal;
    }

    private void setOpponentReal(boolean opponentReal) {
        this.opponentReal = opponentReal;
    }

    public void askOpponentReal() {
        System.out.println("Do you want to play against a \"computer\" or a \"person\"");
        String input = scanner.nextLine();
        boolean keepGoing = true;
        do {
            switch (input.toLowerCase()) {
                case "person":
                    setOpponentReal(true);
                    keepGoing = false;
                    break;
                case "computer":
                    setOpponentReal(false);
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Input not accepted, please type \"computer\" or \"person\".");
                    input = scanner.nextLine();
                    break;
            }
        } while (keepGoing);
    }

    public void askOpponentReal(String input) {
        System.out.println("Do you want to play against a \"computer\" or a \"person\"");
        System.out.println(input);
        if (input.toLowerCase().equals("person")){
            setOpponentReal(true);
        }else if (input.toLowerCase().equals("computer")){
            setOpponentReal(false);
        }
    }

    public void createPlayers() {

        if (opponentReal) {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName();

            player2 = new Player();
            System.out.println("Player 2:");
            player2.askName();
        }else {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName();

            computer = new Computer();
        }

    }

    public void createPlayers(String name1, String name2) {

        if (opponentReal) {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName(name1);

            player2 = new Player();
            System.out.println("Player 2:");
            player2.askName(name2);
        }else {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName(name1);

            computer = new Computer();
        }

    }

    public void createPlayers(String name1) {

        if (opponentReal) {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName(name1);

            player2 = new Player();
            System.out.println("Player 2:");
            player2.askName("shouldnt");
        }else {
            player1 = new Player();
            System.out.println("Player 1:");
            player1.askName(name1);

            computer = new Computer();
        }

    }

    public void createChoices() {

        if (opponentReal) {
            player1.askChoice();
            player2.askChoice();
        }else {
            player1.askChoice();
            computer.rollChoice();
        }

    }

    public void createChoices(String choice1) {

        if (opponentReal) {
            player1.askChoice(choice1);
            player2.askChoice();
        }else {
            player1.askChoice(choice1);
            computer.rollChoice();
        }

    }

    public void createChoices(String choice1, String choice2) {

        if (opponentReal) {
            player1.askChoice(choice1);
            player2.askChoice(choice2);
        }else {
            player1.askChoice(choice1);
            computer.rollChoice();
        }

    }

    public int getWinner() {
        return winner;
    }

    private void setWinner(int winner) {
        this.winner = winner;
    }

    public void chooseWinner() {

        System.out.println("Time to play!");
        System.out.println("Rock! (press enter)");
        scanner.nextLine();
        System.out.println("Paper! (press enter)");
        scanner.nextLine();
        System.out.println("Scissors! (press enter)");
        scanner.nextLine();
        System.out.println("Shoot! (press enter)");
        scanner.nextLine();

        if (opponentReal){
            System.out.println(player1.getName() + " - " + player1.getChoice() + " vs " + player2.getChoice() + " - " + player2.getName()+"\n");
            chooseWinningSide(player1.getChoice(), player2.getChoice());
            if (getWinner() == 1) {
                System.out.println(player1.getName() + " Wins!");
                pastGames.addPastGame("(Winner) " + player1.getName() + " - " + player1.getChoice() + " vs " + player2.getChoice() + " - " + player2.getName());
            }else if (getWinner() == 2) {
                System.out.println(player2.getName() + " Wins!");
                pastGames.addPastGame(player1.getName() + " - " + player1.getChoice() + " vs " + player2.getChoice() + " - " + player2.getName() + " (Winner)");
            }
        }else {
            System.out.println(player1.getName() + " - " + player1.getChoice() + " vs " + computer.getChoice() + " - " + computer.getName()+"\n");

            chooseWinningSide(player1.getChoice(), computer.getChoice());
            if (getWinner() == 1) {
                System.out.println(player1.getName() + " Wins!");
                pastGames.addPastGame("(Winner) " + player1.getName() + " - " + player1.getChoice() + " vs " + computer.getChoice() + " - " + computer.getName());
            }else if (getWinner() == 2) {
                System.out.println(computer.getName() + " Wins!");
                pastGames.addPastGame(player1.getName() + " - " + player1.getChoice() + " vs " + computer.getChoice() + " - " + computer.getName() + " (Winner)");
            }
        }

        if (getWinner() == 3) {
            System.out.println("It was a tie! Try again!\n");
        }else {
            System.out.println("\n\nType \"menu\" to go to the Main Menu.\nType \"play\" to play again with the same settings.\nType \"exit\" to quit.");
            String input = Game.scanner.nextLine();
            boolean keepGoing = true;
            do {
                switch (input.toLowerCase()) {
                    case "menu":
                        setSingleGame(false);
                        keepGoing = false;
                        break;
                    case "play":
                        keepGoing = false;
                        break;
                    case "exit":
                        setSingleGame(false);
                        setFullGame();
                        keepGoing = false;
                        break;
                    default:
                        System.out.println("You typed \"" + input.toLowerCase() + "\", that doesn\'t match any of the choices.\nPlease type \"menu\", \"play\", or \"exit\"!");
                        input = Game.scanner.nextLine();
                }
            } while (keepGoing);
        }

    }

    public void chooseWinningSide(String choice1, String choice2) {

        if (choice1.equals("rock") && choice2.equals("rock")
                || choice1.equals("paper") && choice2.equals("paper")
                || choice1.equals("scissors") && choice2.equals("scissors")) {
             setWinner(3);
        } else if (choice1.equals("paper") && choice2.equals("rock")
                || choice1.equals("scissors") && choice2.equals("paper")
                || choice1.equals("rock") && choice2.equals("scissors")) {
            setWinner(1);
        } else if (choice1.equals("scissors") && choice2.equals("rock")
                || choice1.equals("rock") && choice2.equals("paper")
                || choice1.equals("paper") && choice2.equals("scissors")) {
             setWinner(2);
        }

    }

    private void showPastGames() {

        if (pastGames.getPastGames().size() == 0) {
            System.out.println("\nNo Past Games.");
        }else {
            for ( String pastGame : pastGames.getPastGames()) {
                System.out.println(pastGame);
            }
        }

    }

    public void mainMenu() {
        System.out.println("Do you want to \"play\" a new game or view \"past\" games.");
        String input = scanner.nextLine();
        boolean keepGoing = true;
        do {
            switch (input.toLowerCase()) {
                case "play":
                    keepGoing = false;
                    break;
                case "past":
                    showPastGames();
                    System.out.println("\n\nDo you want to \"play\" a new game or view \"past\" games.");
                    input = scanner.nextLine();
                    break;
                default:
                    System.out.println("Input not accepted, please type \"play\" or \"past\".");
                    input = scanner.nextLine();
                    break;
            }
        } while (keepGoing);
    }

}
