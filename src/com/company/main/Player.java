package com.company.main;

public class Player {

    private String name;
    private String choice;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void askName() {
        System.out.println("Please enter a name for yourself! (10 character limit)");
        String input = Game.scanner.nextLine();
        boolean keepGoing = true;
        do {
            if (input.length() < 10){
                setName(input);
                keepGoing = false;
            }else {
                System.out.println("Name is too long, please type a name that is less than 10 characters.");
                input = Game.scanner.nextLine();
            }
        } while (keepGoing);
    }

    public void askName(String name) {
        System.out.println("Please enter a name for yourself! (10 character limit)");
        if (name.length() < 10){
            setName(name);
            System.out.println(this.getName());
        }
    }

    public String getChoice() {
        return choice;
    }

    private void setChoice(String choice) {
        this.choice = choice;
    }

    public void askChoice() {
        System.out.println(getName() + " choose rock, paper, or scissors!");
        String input = Game.scanner.nextLine();
        boolean keepGoing = true;
        do {
            switch (input.toLowerCase()) {
                case "rock":
                    setChoice("rock");
                    keepGoing = false;
                    break;
                case "paper":
                    setChoice("paper");
                    keepGoing = false;
                    break;
                case "scissors":
                    setChoice("scissors");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("You typed \"" + input.toLowerCase() + "\", that doesn\'t match any of the choices.\nPlease type \"rock\", \"paper\", or \"scissors\"!");
                    input = Game.scanner.nextLine();
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        } while (keepGoing);
    }

    public void askChoice(String input) {
        System.out.println(getName() + " choose rock, paper, or scissors!");
        switch (input.toLowerCase()) {
            case "rock":
                setChoice("rock");
                break;
            case "paper":
                setChoice("paper");
                break;
            case "scissors":
                setChoice("scissors");
                break;
        }
    }

}
