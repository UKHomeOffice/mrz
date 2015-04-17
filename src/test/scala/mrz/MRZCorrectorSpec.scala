package mrz

import org.specs2.mutable.Specification

class MRZCorrectorSpec extends Specification {

    val corrector = new MRZCorrector{}

    "MRZ Corrector" should {

      "correct common mistakes" in {
        val incorrectMRZ = MRZ("P", "GBR", "PARKER", "BEN CHRISTOPHER", "3O2116252", "O", "GBR", "7304O7", "3", "M", "1306I1", "2", "", "D", "4")

        val correctedMRZ = corrector.correct(incorrectMRZ)

        correctedMRZ mustEqual MRZ("P", "GBR", "PARKER", "BEN CHRISTOPHER", "302116252", "0", "GBR", "730407", "3", "M", "130611", "2", "", "0", "4")
      }
    }

}
