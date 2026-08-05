package com.idrsolutions.bulkconversion.tifftojpeg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageIOExample {

    public static void main(String[] args) {
        File inputDir = new File("tif");
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("tiffInputDirectory");
        ImageReader reader = readers.next();

        for (File f : Objects.requireNonNull(inputDir.listFiles())) {
            try {
                ImageInputStream iis = ImageIO.createImageInputStream(f);
            reader.setInput(iis);
            BufferedImage page = reader.read(0);
            ImageIO.write(page, "jpg", new File("imageioExample-" + f.getName().substring(0, f.getName().indexOf('.')) + ".jpg"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
