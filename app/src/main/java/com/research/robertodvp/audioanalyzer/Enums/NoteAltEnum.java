package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 26/03/2017.
 */

public enum NoteAltEnum {
    SHARP("Sharp","Sostenido","sharp",24,48,-20,-162),
    FLAT("Flat","Bemol","flat",29,53,-20,-172),
    DSHARP("Double sharp","Doble sostenido","dsharp",24,24,-22,-148),
    DFLAT("Double flat","Doble bemol","dflat",40,50,-30,-172),
    SINGLE("Single","Sencilla", "",24,48,0,-150),
    REMOVE("","","",0,0,0,0);

    private final String noteAltNameEng;
    private final String noteAltNameEsp;
    private final String imgFileName;
    private final int noteAltWidth;
    private final int noteAltHeight;
    private final int _x;
    private final int _y;


    private NoteAltEnum(String noteAltNameEng, String noteAltNameEsp, String imgFileName, int noteAltWidth, int noteAltHeight, int _x, int _y) {
        this.noteAltNameEng = noteAltNameEng;
        this.noteAltNameEsp = noteAltNameEsp;
        this.imgFileName = imgFileName;
        this.noteAltWidth = noteAltWidth;
        this.noteAltHeight = noteAltHeight;
        this._x=_x;
        this._y=_y;
    }

    public String getNoteAltNameEng() {
        return noteAltNameEng;
    }

    public String getNoteAltNameEsp() {
        return noteAltNameEsp;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public int getNoteAltWidth() {
        return noteAltWidth;
    }

    public int getNoteAltHeight() {
        return noteAltHeight;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

}
