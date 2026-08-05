package com.idrsolutions.extractmultipage.tiff;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.formats.tiff.TiffImageParser;

public class ApacheExample {

    public static void main(String[] args) throws Exception {
        File input =  new File("multipage_tiff_example.tif");
        TiffImageParser tip = new TiffImageParser();
        AtomicInteger imageCount = new AtomicInteger();
        tip.getAllBufferedImages(input).forEach(page -> {
            try {
                Imaging.writeImage(page, new File("apacheExample" + imageCount.getAndIncrement() + ".png"), ImageFormats.PNG);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
