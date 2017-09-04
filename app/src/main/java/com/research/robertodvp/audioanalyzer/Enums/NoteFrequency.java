package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 01/05/2017.
 */

public enum NoteFrequency {
    C8("C",8,4186.01),
    B7("B",7,3951.07),
    AS7("AS",7,3729.31),
    A7("A",7,3520.00),
    GS7("GS",7,3322.44),
    G7("G",7,3135.96),
    FS7("FS",7,2959.96),
    F7("F",7,2793.83),
    E7("E",7,2637.02),
    DS7("DS",7,2489.02),
    D7("D",7,2349.32),
    CS7("CS",7,2217.46),
    C7("C",7,2093.00),
    B6("B",6,1975.53),
    AS6("AS",6,1864.66),
    A6("A",6,1760.00),
    GS6("GS",6,1661.22),
    G6("G",6,1567.98),
    FS6("FS",6,1479.98),
    F6("F",6,1396.91),
    E6("E",6,1318.51),
    DS6("DS",6,1244.51),
    D6("D",6,1174.66),
    CS6("CS",6,1108.73),
    C6("C",6,1046.5),
    B5("B",5,987.767),
    AS5("AS",5,932.328),
    A5("A",5,880.00),
    GS5("GS",5,830.609),
    G5("G",5,783.991),
    FS5("FS",5,739.989),
    F5("F",5,698.456),
    E5("E",5,659.255),
    DS5("DS",5,622.254),
    D5("D",5,587.33),
    CS5("CS",5,554.365),
    C5("C",5,523.251),
    B4("B",4,493.883),
    AS4("AS",4,466.164),
    A4("A",4,440.00),
    GS4("GS",4,415.305),
    G4("G",4,391.995),
    FS4("FS",4,369.994),
    F4("F",4,349.228),
    E4("E",4,329.628),
    DS4("DS",4,311.127),
    D4("D",4,293.665),
    CS4("CS",4,277.183),
    C4("C",4,261.626),
    B3("B",3,246.942),
    AS3("AS",3,233.082),
    A3("A",3,220.00),
    GS3("GS",3,207.652),
    G3("G",3,195.998),
    FS3("FS",3,184.997),
    F3("F",3,174.614),
    E3("E",3,164.814),
    DS3("DS",3,155.563),
    D3("D",3,146.832),
    CS3("CS",3,138.591),
    C3("C",3,130.813),
    B2("B",2,123.471),
    AS2("AS",2,116.541),
    A2("A",2,110.00),
    GS2("GS",2,103.826),
    G2("G",2,97.9989),
    FS2("FS",2,92.4986),
    F2("F",2,87.3071),
    E2("E",2,82.4069),
    DS2("DS",2,77.7817),
    D2("D",2,73.4162),
    CS2("CS",2,69.2957),
    C2("C",2,65.4064),
    B1("B",1,61.7354),
    AS1("AS",1,58.2705),
    A1("A",1,55.00),
    GS1("GS",1,51.913),
    G1("G",1,48.9995),
    FS1("FS",1,46.2493),
    F1("F",1,43.6536),
    E1("E",1,41.2035),
    DS1("DS",1,38.8909),
    D1("D",1,36.7081),
    CS1("CS",1,34.6479),
    C1("C",1,32.7032),
    B0("B",0,30.8677),
    AS0("AS",0,29.1353),
    A0("A",0,27.5)
    ;

    private final String mNoteName;
    private final Integer mOctave;
    private final Double mFrequency;

    public String getmNoteName() {
        return mNoteName;
    }

    public Integer getmOctave() {
        return mOctave;
    }

    public Double getmFrequency() {
        return mFrequency;
    }

    private NoteFrequency(String mNoteName, Integer mOctave, Double mFrequency) {
        this.mNoteName = mNoteName;
        this.mOctave = mOctave;
        this.mFrequency = mFrequency;
    }
}
