package mrz

import org.specs2.mutable.Specification

class MRZSpec extends Specification {

  "MRZ" should {

    "parse MRZ text" in {

      val mrzText = "P<GBRPARKER<<BEN<CHRISTOPHER<<<<<<<<<<<<<<<<3021162520GBR7304073M1306112<<<<<<<<<<<<<<04"

      MRZ(mrzText) mustEqual MRZ("P", "GBR", "PARKER", "BEN CHRISTOPHER", "302116252", "0", "GBR", "730407", "3", "M", "130611", "2", "", "0", "4")
    }
  }
}
