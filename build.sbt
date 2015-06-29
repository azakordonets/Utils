import scoverage.ScoverageSbtPlugin.ScoverageKeys

name := "Utils"

version := "1.0"

scalaVersion := "2.11.4"

  resolvers ++= Seq(
    "RoundEights" at "http://maven.spikemark.net/roundeights"
)

resolvers ++= Seq(
  "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/"
)

libraryDependencies ++= Seq(
  "org.mindrot" % "jbcrypt" % "0.3m"
)

libraryDependencies ++= Seq(
  "org.testng" % "testng" % "6.8.8" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0-SNAP4" % "test",
  "com.github.nscala-time" %% "nscala-time" % "1.2.0",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "com.roundeights" %% "hasher" % "1.0.0"
)

ScoverageKeys.coverageMinimum := 90

ScoverageKeys.coverageFailOnMinimum := true

ScoverageKeys.coverageHighlighting := {
  if (scalaBinaryVersion.value == "2.10") true else false
}
    