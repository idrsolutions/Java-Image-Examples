package com.idrsolutions.bulkconversion.tifftojpeg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import org.apache.commons.imaging.Imaging;

public class ApacheExample {

    public static void main(String[] args) {
        File inputDir = new File("tif");

        for (File f : Objects.requireNonNull(inputDir.listFiles())) {
            try {
                BufferedImage page = Imaging.getBufferedImage(f);
                // Apache cannot write JPEG so ImageIO will still be needed to encode the images
                ImageIO.write(page, "jpg", new File("Apache-imageio-" + f.getName().substring(0, f.getName().indexOf('.')) + ".jpg"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
