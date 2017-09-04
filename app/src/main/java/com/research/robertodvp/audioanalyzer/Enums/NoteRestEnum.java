package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 07/04/2017.
 */

public enum NoteRestEnum {

    NOTE("Note", "Nota", "note",0,0,0,0),
    REST("Rest", "Silencio","rest",0,0,0,0);

    private final String noteRestNameEng;
    private final String noteRestNameEsp;
    private final String imgFileNameFig;
    private final int _width;
    private final int _height;
    private final int _x;
    private final int _y;


    private NoteRestEnum(String noteRestNameEng, String noteRestNameEsp, String imgFileNameFig, int _width, int _height, int _x, int _y) {
        this.noteRestNameEng = noteRestNameEng;
        this.noteRestNameEsp = noteRestNameEsp;
        this.imgFileNameFig = imgFileNameFig;
        this._width=_width;
        this._height=_height;
        this._x = _x;
        this._y = _y;
    }

    public String noteRestNameEng() {
        return noteRestNameEng;
    }

    public String noteRestNameEsp() {
        return noteRestNameEsp;
    }

    public String getImgFileNameFig() {
        return imgFileNameFig;
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

}
