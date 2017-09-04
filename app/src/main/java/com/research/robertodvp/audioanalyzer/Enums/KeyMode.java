package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 30/04/2017.
 */

public enum KeyMode {
    MAJOR("Major","Mayor"),
    MINOR("Minor","Menor");

    public String getKeyModeEng() {
        return KeyModeEng;
    }

    public String getKeyModeEsp() {
        return KeyModeEsp;
    }

    private final String KeyModeEng;
    private final String KeyModeEsp;

    private KeyMode(String KeyModeEng, String KeyModeEsp) {
        this.KeyModeEng = KeyModeEng;
        this.KeyModeEsp = KeyModeEsp;
    }

}
