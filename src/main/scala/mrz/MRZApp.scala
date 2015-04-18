package mrz

object MRZApp extends App with MRZReader with MRZCorrector {

  val filename = args(0)
  println("Reading MRZ from image file: " + filename)

  val mrz = readMRZ(filename)

  println("==================================================")
  println("Issuing country: " + mrz.issuingCountry)
  println("Last name: " + mrz.lastName)
  println("Given names: " + mrz.givenNames)
  println("Gender: " + mrz.gender)
  println("Nationality: " + mrz.nationality)
  println("Date of birth: " + mrz.dob)
  println("Passport No: " + mrz.passportNo)
  println("Passport expiry date: " + mrz.passportExpirationDate)
  println("Personal number: " + mrz.personalNo)
  println("==================================================")

}
