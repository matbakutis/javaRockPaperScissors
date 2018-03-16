package com.company.main;

import java.util.ArrayList;

public class PastGames {

    private ArrayList<String> pastGames = new ArrayList<>();

    public ArrayList<String> getPastGames() {
        return pastGames;
    }

    public void addPastGame(String pastGame) {
        this.pastGames.add(pastGame);
    }
}
