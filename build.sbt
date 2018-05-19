ThisBuild / organization := "com.eed3si9n"
ThisBuild / version      := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
    name := "sbt-sriracha",
    description := "sbt plugin to define hybrid source/binary dependency",
    licenses := Seq("MIT License" -> url("https://github.com/sbt/sbt-sriracha/blob/master/LICENSE")),
    scalacOptions := Seq("-deprecation", "-unchecked"),
    publishMavenStyle := false,
    bintrayOrganization in bintray := None,
    bintrayRepository := "sbt-plugins",
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false,
  )
