import Dependencies._

lazy val root = Project(id = "comments", base = file("."))
  .settings(
    name := "comments",
    scalaVersion := "2.13.8",
    version := "1.0.0-SNAPSHOT",
    libraryDependencies ++= HttpServerLibs ++ CirceLibs ++ Slick :+ Specs2 :+ LogBackClassic,
    scalacOptions ++= Seq(
      "-Ymacro-annotations"
    )
  )

Global / onChangedBuildSource := ReloadOnSourceChanges
