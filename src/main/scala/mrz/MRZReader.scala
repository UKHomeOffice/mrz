package mrz

import java.io.File
import scala.io.Source

trait MRZReader {
  val corrector = new MRZCorrector{}

  def readMRZ(filename: String): MRZ = corrector.correct(MRZ(mrz(ocr(filename))))

  def ocr(filename: String): String = {
    val file = new File(filename)
    require(file.canRead)
    parseImageTextCommandLine(filename)
  }

  private def parseImageTextCommandLine(filename: String) = {
    import scala.sys.process._
    val command = s"tesseract $filename out"
    println(s"Calling $command")
    command.!
    Source.fromFile("out.txt").mkString
  }

  def mrz(ocrString: String) = {
    val startPos = ocrString.indexOf("P<")
    ocrString.substring(startPos, startPos + 89).replaceAll(System.getProperty("line.separator"), "")
  }

  // This java lib doesnt work very well so we call the command from the system
  //
  //  private def parseImageText(file: File) = {
  //    val tesseract = Tesseract.getInstance()
  //    try {
  //      val text = tesseract.doOCR(file)
  //      println(text)
  //      Some(text)
  //    } catch {
  //      case e: Exception => None
  //    }
  //  }
}
