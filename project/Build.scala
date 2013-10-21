import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play2"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    cache,
    "com.typesafe.slick" %% "slick" % "1.0.1",
    "com.typesafe.play" %% "play-slick" % "0.5.0.8",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "mysql" % "mysql-connector-java" % "5.1.26"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    scalaVersion := "2.10.2"
  )

}
