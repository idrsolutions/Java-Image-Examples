# Converting TIFF to JPEG in Java

Converting an image to JPEG in Java looks simple until you hit alpha channels, colour space mismatches, or missing writer plugins. This package shows how three common approaches handle it.

This is one example among several in this repo. For the full picture of JDeli's conversion support, see [our docs](https://www.idrsolutions.com/docs/jdeli/image-conversion-all/).

## The problem
JPEG has no alpha channel. If you're converting from a format that does (PNG, GIF with transparency), you need to flatten or strip alpha before encoding, or the write will throw IIOException: Bogus input colorspace (ImageIO) or fail silently depending on the library. This trips people up often enough that it's worth calling out on its own.

## Libraries covered

| Library                 | Notes                                                                                       |
|-------------------------|---------------------------------------------------------------------------------------------|
| Apache + ImageIO        | Apache for reading tiff and ImageIO to write JPEG                                           |
| ImageIO (JDK built-in)  | No extra dependency, but limited format/quality control and the alpha-channel gotcha above  |
| JDeli                   | Handles alpha flattening automatically, more format support out of the box                  |


## Related
- [Read our blog post on how to mass convert TIFF to JPEG](https://blog.idrsolutions.com/how-to-mass-convert-tiff-to-jpg-tutorial/)
- [Read our documentation on converting TIFF to JPG in JDeli](https://www.idrsolutions.com/docs/jdeli/tutorials/converting/all/tiff/convert-tiff-to-jpg)