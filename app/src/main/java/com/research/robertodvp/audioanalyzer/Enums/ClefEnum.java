package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 21/04/2017.
 */

public enum ClefEnum {
    TREBLE("Treble","Sol","trebleclef",90,256,70,160),
    BASS("Bass","Fa","bassclef",105,300,70,115),
    ALTO("Alto","DoTercera","altoclef",105,300,70,115),
    NEUTRAL("Neutral","neutral","neutralclef",105,300,70,115),
    GRANDSTAFF("TREBLE,BASS","Grand Staff","grandstaff",90,256,70,160); //this one will use TREBLE and BASS

    private final String clefNameEng;
    private final String cleftNameEsp;
    private final String imgFileName;
    private final int _width;
    private final int _height;
    private final int _x;
    private final int _y;


    private ClefEnum(String clefNameEng, String cleftNameEsp, String imgFileName, int _width, int _height, int _x, int _y) {
        this.clefNameEng = clefNameEng;
        this.cleftNameEsp = cleftNameEsp;
        this.imgFileName = imgFileName;
        this._width = _width;
        this._height = _height;
        this._x=_x;
        this._y=_y;
    }

    public String getClefNameEng() {
        return clefNameEng;
    }

    public String getCleftNameEsp() {
        return cleftNameEsp;
    }

    public String getImgFileName() {
        return imgFileName;
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
    }}
