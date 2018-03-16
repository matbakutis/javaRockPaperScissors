package com.company.main;

public class Computer {

    private String name = "Mr. Roboto";
    private String choice;

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

    private void setChoice(String choice) {
        this.choice = choice;
    }

    public void rollChoice() {
        switch ((int)(Math.random() * 3) + 1) {
            case 1:
                setChoice("rock");
                break;
            case 2:
                setChoice("paper");
                break;
            case 3:
                setChoice("scissors");
                break;
        }
    }

}
