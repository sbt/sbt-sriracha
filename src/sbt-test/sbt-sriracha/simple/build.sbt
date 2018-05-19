ThisBuild / scalaVersion := "2.12.6"

val someOtherRef = ProjectRef(IO.toURI(file("some-other")), "root")
val someOtherLib = "com.example" % "some-other" % "0.1.0-SNAPSHOT"

val x = setSourceMode(true)

lazy val root = (project in file("."))
  .settings(
    name := "hello"
  )
  .sourceDependency(someOtherRef, someOtherLib)
