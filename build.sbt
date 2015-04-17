name := "mrz"

version := "1.0"

scalaVersion := "2.11.5"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers += "MyGrid" at "http://repository.mygrid.org.uk/artifactory/mygrid-all"

resolvers += "GHost" at "http://repo.ghost4j.org/maven2/releases"

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies += "org.specs2" %% "specs2-core" % "3.4" % "test"

libraryDependencies += "net.sourceforge.tess4j" % "tess4j" % "2.0.0"



