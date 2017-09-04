package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 23/07/2017.
 */

public enum InstrumentEnum {
    //Instrument type, fixed clef (grandstaff default is treble), name for to get attrs xml file,  range of frequencies ( this will be by default retrieved XML ), (ideally: possible gestures..., possible dynamics..., override gestures and dynamics 0/1)
    //Percussion //pending to review and analyze all instruments this phase is piano only
    PIANO(InstrumentType.PERCUSSION,ClefEnum.GRANDSTAFF,"piano"),
    XYLOPHONE(InstrumentType.PERCUSSION,ClefEnum.TREBLE, "xylophone"),
    TIMPANI(InstrumentType.PERCUSSION,ClefEnum.BASS,"timpain"),
    BASSDRUM(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"bassdrum"),
    CYMBALS(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"cymbals"),
    CASTANETS(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"castanets"),
    TRIANGLE(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"triangle"),
    SNAREDRUM(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"snaredrum"),
    TAMBOURINE(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"tambourine"),
    MARACAS(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"maracas"),
    GONGS(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"gongs"),
    CHIMES(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"chimes"),
    CELESTA(InstrumentType.PERCUSSION,ClefEnum.NEUTRAL,"celesta"),

    //Strings
    VIOLIN(InstrumentType.STRINGS,ClefEnum.NEUTRAL,"violin"),
    VIOLA(InstrumentType.STRINGS,ClefEnum.NEUTRAL,"viola"),
    CELLO(InstrumentType.STRINGS,ClefEnum.NEUTRAL,"cello"),
    DOUBLEBASS(InstrumentType.STRINGS,ClefEnum.NEUTRAL,"doublebass"),
    HARP(InstrumentType.STRINGS,ClefEnum.NEUTRAL,"harp"),

    //Brass
    TRUMPET(InstrumentType.BRASS,ClefEnum.NEUTRAL,"trumpet"),
    TROMBONE(InstrumentType.BRASS,ClefEnum.NEUTRAL,"trombone"),
    CORNET(InstrumentType.BRASS,ClefEnum.NEUTRAL,"cornet"),
    ALTOHORN(InstrumentType.BRASS,ClefEnum.NEUTRAL,"altohorn"),
    BARITONEHORN(InstrumentType.BRASS,ClefEnum.NEUTRAL,"baritonehorn"),
    FLUGELHORN(InstrumentType.BRASS,ClefEnum.NEUTRAL,"flugelhorn"),
    MELLOPHONE(InstrumentType.BRASS,ClefEnum.NEUTRAL,"mellophone"),
    EUPHONIUM(InstrumentType.BRASS,ClefEnum.NEUTRAL,"euphonium"),
    HELICON(InstrumentType.BRASS,ClefEnum.NEUTRAL,"helicon"),
    TUBA(InstrumentType.BRASS,ClefEnum.NEUTRAL,"tuba"),
    FRENCHHORN(InstrumentType.BRASS,ClefEnum.NEUTRAL,"frenchhorn"),

    //WindWood
    PICCOLO(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"piccolo"),
    FLUTE(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"flute"),
    OBOE(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"oboe"),
    ENGLISHHORN(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"englishhorn"),
    CLARINET(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"clarinet"),
    EFLATCLARINET(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"eflatclarinet"),
    BASSCLARINET(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"bassclarinet"),
    BASSOON(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"bassoon"),
    CONTRABASSOON(InstrumentType.WOODWIND,ClefEnum.NEUTRAL,"contrabassoon");

    public InstrumentType getmInstrumentType() {
        return mInstrumentType;
    }

    public ClefEnum getmClefEnum() {
        return mClefEnum;
    }

    public String getmInstrumentName() {
        return mInstrumentName;
    }

    private final InstrumentType mInstrumentType;
    private final ClefEnum mClefEnum;
    private final String mInstrumentName;


    private InstrumentEnum(InstrumentType instrumentType, ClefEnum clefEnum, String instrumentName) {
        this.mInstrumentType = instrumentType;
        this.mClefEnum = clefEnum;
        this.mInstrumentName = instrumentName;
    }

}
