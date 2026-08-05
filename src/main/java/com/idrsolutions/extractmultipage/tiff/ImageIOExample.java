package com.idrsolutions.extractmultipage.tiff;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageIOExample {

    public static void main(String[] args) throws Exception {
        ImageInputStream iis = ImageIO.createImageInputStream(new File("multipage_tiff_example.tif"));
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
        ImageReader reader = readers.next();
        reader.setInput(iis);

        int pageCount = reader.getNumImages(true); // true = allow scan
        for (int i = 0; i < pageCount; i++) {
            BufferedImage page = reader.read(i);
            ImageIO.write(page, "png", new File("imageioExample" + i + ".png"));
        }
    }
}
