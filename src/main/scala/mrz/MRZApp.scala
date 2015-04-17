package mrz

object MRZApp extends App with MRZReader {

  val filename = args(0)
  println("Reading MRZ from image file: " + filename)

  val mrz = readMRZ(filename)

  println(mrz)
}
