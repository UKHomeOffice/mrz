package mrz

import java.io.File
import scala.io.Source

trait MRZReader {
  val corrector = new MRZCorrector{}

  def readMRZ(filename: String): MRZ = {
    val imageText = ocr(filename)
    val mrzText = mrz(imageText)
    corrector.correct(MRZ(mrzText))
  }

  def ocr(filename: String): String = {
    val file = new File(filename)
    require(file.canRead)
    parseImageTextCommandLine(filename)
  }

  private def parseImageTextCommandLine(filename: String) = {
    import scala.sys.process._
    s"tesseract $filename out".!
    Source.fromFile("out.txt").mkString
  }

  def mrz(ocrString: String) = {
    val startPos = ocrString.indexOf("P<")
    ocrString.substring(startPos, startPos + 89).replaceAll(System.getProperty("line.separator"), "")
  }
}
