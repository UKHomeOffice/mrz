package mrz

case class MRZ(idType: String, issuingCountry: String, lastName: String, givenNames: String, passportNo: String,
               checkDigit1: String, nationality: String, dob: String, checkDigit2: String, gender: String,
               passportExpirationDate: String, checkDigit3: String, personalNo: String, checkDigit4: String, checkDigit5: String)

object MRZ {

  def apply(txt: String): MRZ = {
    val idType = txt.substring(0, 2).replace('<', ' ').trim
    val issuingCountry = txt.substring(2, 5)
    val Array(lastName, givenNamesWithChevron, _*) = txt.substring(5,44).split("<<")
    val givenNames = givenNamesWithChevron.replace('<', ' ').trim
    val passportNo = txt.substring(44, 53)
    val checkDigit1 = txt.substring(53, 54)
    val nationality = txt.substring(54, 57)
    val dob = txt.substring(57, 63)
    val checkDigit2 = txt.substring(63, 64)
    val gender = txt.substring(64, 65)
    val passportExpirationDate = txt.substring(65, 71)
    val checkDigit3 = txt.substring(71, 72)
    val personalNo = txt.substring(72, 86).replace('<', ' ').trim
    val checkDigit4 = txt.substring(86, 87)
    val checkDigit5 = txt.substring(87, 88)

    MRZ(idType, issuingCountry, lastName, givenNames, passportNo, checkDigit1, nationality,
        dob, checkDigit2, gender, passportExpirationDate, checkDigit3, personalNo, checkDigit4, checkDigit5)
  }
}