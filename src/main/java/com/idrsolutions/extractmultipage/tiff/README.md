# Extracting Pages from Multipage TIFFs in Java

TIFF is one of the few common image formats that can hold multiple pages in a single file. Reading it isn't a straight ImageIO.read(), you need an ImageReader that exposes page count and can seek to a specific index, and the plain JDK doesn't ship a TIFF reader out of the box.

This is one example among several in this repo. For the full picture of JDeli's TIFF support, see our [docs](https://www.idrsolutions.com/docs/jdeli/).

## The problem

ImageIO.read() only ever returns a single BufferedImage, the first page. To get the rest, you need to work with ImageReader directly: get the number of images with getNumImages(true), then call read(index) for each page.

TIFF has been a standard, built-in ImageIO plugin since JDK 9 (javax.imageio.plugins.tiff, part of java.desktop), so no extra dependency is needed for basic reading on modern JDKs. On JDK 8 and earlier you'd need a third-party plugin such as TwelveMonkeys.

## Libraries covered
| Library               | Notes                                                                            |
|-----------------------|----------------------------------------------------------------------------------|
| Apache                |                                                                                  |
| ImageIO(since Java 9) | Also can have the use of TwelveMonkeys plugin                                    |
| JDeli                 | TIFF reading built in, page count and per-page access without extra dependencies |


## Related
- [Read our blog post on reading tiff files](https://blog.idrsolutions.com/how-to-read-tiff-images-in-java/)
- [Read our documentation on how to read multi-page tiff files with JDeli](https://www.idrsolutions.com/docs/jdeli/tutorials/reading/java-tiff-reader#read-multi-image-tiff-files)
