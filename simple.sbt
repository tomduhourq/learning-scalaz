name:= "learning-scalaz"

version:= "0.0.1-SNAPSHOT"

scalaVersion:= "2.11.7"

val scalaZVersion = "7.1.4"

val coreDependencies = Seq (
  "org.scalaz" %% "scalaz-core" % scalaZVersion
)

val testDependencies = Seq (
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

libraryDependencies ++= coreDependencies ++ testDependencies

scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

test in assembly := {}

parallelExecution in Test := false

fork in Test := false

assemblyJarName in assembly := "learning-ScalaZ-" + scalaZVersion + ".jar"






