name := "Utils"

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.testng" % "testng" % "6.8.8" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0-SNAP4" % "test",
  "com.github.nscala-time" %% "nscala-time" % "1.2.0",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
)
    