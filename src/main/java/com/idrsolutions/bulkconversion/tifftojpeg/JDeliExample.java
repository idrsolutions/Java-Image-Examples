package com.idrsolutions.bulkconversion.tifftojpeg;

import com.idrsolutions.image.JDeli;
import java.io.File;

public class JDeliExample {

    public static void main(String[] args) throws Exception {
        File inputDir = new File("tiffInputDirectory");
        File outputDir = new File("jdeliOutputDirectory");

        JDeli.convert(inputDir, outputDir);
    }
}
