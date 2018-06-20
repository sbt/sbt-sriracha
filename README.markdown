sbt-sriracha
============

[![Build Status](https://travis-ci.org/sbt/sbt-sriracha.svg?branch=master)](https://travis-ci.org/sbt/sbt-sriracha)

hot sauce for your build.

This is an experimental plugin to support source/binary hybrid dependencies.

setup
-----

In `project/plugins.sbt`:

```scala
addSbtPlugin("com.eed3si9n" % "sbt-sriracha" % "0.1.0")
```

usage
-----

To use GitHub as hybrid dependency:

```scala
lazy val utestJVMRef = ProjectRef(uri("git://github.com/eed3si9n/utest.git#5b19f47c"), "utestJVM")
lazy val utestJVMLib = "com.lihaoyi" %% "utest" % "0.6.4"

lazy val root = (project in file("."))
  .sourceDependency(utestJVMRef, utestJVMLib)
  .settings(
    name := "Hello world",
    testFrameworks += new TestFramework("utest.runner.Framework"),
  )
```

To use local repo as hybrid dependency:

```scala
lazy val utestJVMRef = ProjectRef(IO.toURI(workspaceDirectory / "utest"), "utestJVM")
lazy val utestJVMLib = "com.lihaoyi" %% "utest" % "0.6.4"

lazy val root = (project in file("."))
  .sourceDependency(utestJVMRef, utestJVMLib)
  .settings(
    name := "Hello world",
    testFrameworks += new TestFramework("utest.runner.Framework"),
  )
```

and clone µTest to `$HOME/workspace/`.

license
-------

MIT License
