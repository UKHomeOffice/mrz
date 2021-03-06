package mrz

import org.specs2.mutable.Specification

class MRZReaderSpec extends Specification {

  object MRZProcessor extends MRZReader with MRZCorrector

  "MRZ Reader" should {

    "read a passport image file" in {
      val text = MRZProcessor.ocr("src/test/resources/passport-images/passport2.jpg")
      text must contain ("P<")
    }

    "parse the MRZ from text" in {
      val ocrText =
        """
          |United Kingdom of Greatddﬂritain and Northern Ireland
          |Passport 1yue/me mmdmwmhmualmbmm Pasaunuu/Passepnnuo
          |I{:_'I‘—_  d ’ passeport fmemmlmm   ; 37 3 0 21 1 6 2 5 Z
          |PARKER _
          |GMvununsu?v6numo_x29_ ,
          |,, , BEN CHR I‘-STOPHER
          |.' - Mauouumymasaummg
          |,." . ‘ ,4 BRITISH CITIZENT
          |'  \‘ DIleoiNﬂIvIOa!adandsaarIo¢;(4) > xv}
          |, _‘__-Y _ »’ 07 APR ./AVR. 73 ,4,
          |  §3°"“""’ T“i'i7E"»"z“i»°“o°Ea"i'?""”"°’
          |“I Dale of osauomaua do aawranca (7) Aumomy/Amome (a)
          |11 DEC /DEC '02 UKPA
          |“I ‘U “ H liuiof 1 3 Hofdafsugnmra/Sianuntma du l|mIIlIrl(!D)
          |P<GBRPARKER<<BEN<CHRISTOPHER<<<<<<<<<<<<<<<<
          |3021162520GBR7304073M1306112<<<<<<<<<<<<<<04
          |k--_ ____ _ . ,. -,.'_‘_.. . , ' 4:
        """.stripMargin

      val mrz = MRZProcessor.mrz(ocrText)

      mrz.length mustEqual 88
      mrz mustEqual "P<GBRPARKER<<BEN<CHRISTOPHER<<<<<<<<<<<<<<<<3021162520GBR7304073M1306112<<<<<<<<<<<<<<04"
    }

    "parse the MRZ from a passport image file" in {
      val mrz = MRZProcessor.readMRZ("src/test/resources/passport-images/passport2.jpg")
      mrz mustEqual MRZ("P", "GBR", "PARKER", "BEN CHRISTOPHER", "302116252", "0", "GBR", "730407", "3", "M", "130611", "2", "", "0", "4")
    }
  }

}
