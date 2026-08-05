package com.idrsolutions.extractmultipage.tiff;

import com.idrsolutions.image.JDeli;
import com.idrsolutions.image.tiff.TiffDecoder;
import java.awt.image.BufferedImage;
import java.io.File;

public class JDeliExample {

    public static void main(String[] args) throws Exception {
        File file = new File("multipage_tiff_example.tif");
        TiffDecoder dec = new TiffDecoder();
        int totalImages = dec.getImageCount(file);
        for (int i = 0; i <= totalImages; i++) {
            BufferedImage image = dec.readImageAt(i, file);
            JDeli.write(image, "png", new File("jdeliExample" + i + ".png"));
        }
    }
}
