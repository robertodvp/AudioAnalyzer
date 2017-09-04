package com.research.robertodvp.audioanalyzer;

/**
 * Created by robertov on 02/03/2017.
 */

import android.graphics.Bitmap;

import java.io.IOException;


public class JavaWalkBufferedImageTest1 {

    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    private void marchThroughImage(Bitmap image) {
        int w = image.getWidth();
        int h = image.getHeight();
        System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getPixel(j, i);
                printPixelARGB(pixel);
                System.out.println("");
            }
        }
    }

}
