package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 07/04/2017.
 */

public enum NoteLast {

    DWHOLE("Double Whole", "Cuadrada", 2, "dwhole","dwholer",0,0,0,0),
    WHOLE("Whole", "Redonda", 1, "whole","wholer",0,0,0,0),
    HALF("Half", "Blanca", 2, "half","halfr",0,0,0,0),
    QUARTER("Quarter", "Negra", 4, "quarter","quarterr",34,96,0,-220),
    EIGHT("Eight", "Corchea", 8, "eight","eightr",0,0,0,0),
    SIXTEENTH("Sixteenth", "Semicorchea", 16, "sixteenth","sixteenthr",0,0,0,0),
    THIRTYSECOND("Thirty Second", "Fusa", 32, "thirtysecond","thirtysecondr",0,0,0,0),
    SIXTYFOURTH("Sixty fourth", "Semifusa", 64, "sixtyfourth","sixtyfourthr",0,0,0,0),
    HTWENTYEIGHT("Hundred twenty eight",  "Garrapatea", 128, "htwentyeight","htwentyeightr",0,0,0,0),
    THFIFTYSIXTH("Two hundred fifty sixth", "Semigarrapatea", 256, "thfiftysixth","thfiftysixthr",0,0,0,0);

    private final String noteLastNameEng;
    private final String noteLastNameEsp;
    private final String imgFileNameFig;
    private final String imgFileNameRest;
    private Integer mValue;
    private final int _width;
    private final int _height;
    private final int _x;
    private final int _y;


    private NoteLast(String noteLastNameEng, String noteLastNameEsp, Integer lValue, String imgFileNameFig, String imgFileNameRest, int _width, int _height, int _x, int _y) {
        this.noteLastNameEng = noteLastNameEng;
        this.noteLastNameEsp = noteLastNameEsp;
        this.mValue = lValue;
        this.imgFileNameFig = imgFileNameFig;
        this.imgFileNameRest = imgFileNameRest;
        this._width=_width;
        this._height=_height;
        this._x = _x;
        this._y = _y;
    }

    public String getNoteLastNameEng() {
        return noteLastNameEng;
    }

    public String getNoteLastNameEsp() {
        return noteLastNameEsp;
    }

    public String getImgFileNameFig() {
        return imgFileNameFig;
    }

    public String getImgFileNameRest() {
        return imgFileNameRest;
    }

    public int get_width() {
        return _width;
    }

    public int get_height() {
        return _height;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public Integer getmValue(){
        return mValue;
    }

}
