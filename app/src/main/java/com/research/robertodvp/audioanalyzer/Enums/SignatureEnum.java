package com.research.robertodvp.audioanalyzer.Enums;

/**
 * Created by robertov on 22/04/2017.
 */

public enum SignatureEnum {
    CMAJOR("C M/A m","Do M/La m","cmam",90,256,70,160),
    GMAJOR("G M/E m","Fa M/Re m","gmem",95,278,70,125);

    private final String signatureNameEng;
    private final String signaturetNameEsp;
    private final String imgFileName;
    private final int _width;
    private final int _height;
    private final int _x;
    private final int _y;


    private SignatureEnum(String signatureNameEng, String signaturetNameEsp, String imgFileName, int _width, int _height, int _x, int _y) {
        this.signatureNameEng = signatureNameEng;
        this.signaturetNameEsp = signaturetNameEsp;
        this.imgFileName = imgFileName;
        this._width = _width;
        this._height = _height;
        this._x=_x;
        this._y=_y;
    }

    public String getsignatureNameEng() {
        return signatureNameEng;
    }

    public String getsignaturetNameEsp() {
        return signaturetNameEsp;
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
    }
}
