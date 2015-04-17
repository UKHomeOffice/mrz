package mrz

trait MRZCorrector {

  def correct(mrz: MRZ): MRZ = {
    mrz.copy(
      passportNo = replaceCommonlyConfused(mrz.passportNo),
      checkDigit1 = replaceCommonlyConfused(mrz.checkDigit1),
      dob = replaceCommonlyConfused(mrz.dob),
      checkDigit2 = replaceCommonlyConfused(mrz.checkDigit2),
      passportExpirationDate = replaceCommonlyConfused(mrz.passportExpirationDate),
      checkDigit3 = replaceCommonlyConfused(mrz.checkDigit3),
      checkDigit4 = replaceCommonlyConfused(mrz.checkDigit4),
      checkDigit5 = replaceCommonlyConfused(mrz.checkDigit5)
    )
  }

  private def replaceCommonlyConfused(str: String) = str.replace('O', '0').replace('D', '0').replace('B', '8').replace('I', '1')
}
