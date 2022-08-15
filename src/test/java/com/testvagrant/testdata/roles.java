package com.testvagrant.testdata;

public enum roles {

    BATSMAN("Batsman"),
    BOWLER("Bowler"),
    WICKET_KEEPER("Wicket-keeper"),
    ALLROUNDER("All-Rounder");

    private final String playerRole;


    roles(String playerRole) {
        this.playerRole = playerRole;
    }

    public String getPlayerRoleName() {
        return playerRole;
    }

}
