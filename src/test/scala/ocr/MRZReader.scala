package ocr

import java.io.File
import net.sourceforge.tess4j.Tesseract

trait MRZReader {

  def readMRZ(filename: String): Option[String] = {
    ocr(filename) map mrz
  }
  
  def ocr(filename: String): Option[String] = {
    val file = new File(filename)
    require(file.canRead)
    parseImageText(file)
  }

  private def parseImageText(file: File) = {
    val tesseract = new Tesseract()
    try {
      val text = tesseract.doOCR(file)
      println(text)
      Some(text)
    } catch {
      case e: Exception => None
    }
  }

  def mrz(ocrString: String) = {
    val startPos = ocrString.indexOf("P<")
    ocrString.substring(startPos, startPos + 89).replaceAll(System.getProperty("line.separator"), "")
  }
}
