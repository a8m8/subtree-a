organization := "com.github.a8m8"

name := "subtree-a"

version := "1.0"

scalaVersion := "2.11.8"
lazy val `subtree-b` = (project in file("modules/subtree-b")).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin)


lazy val `subtree-a` = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin)
    .dependsOn(`subtree-b`).aggregate(`subtree-b`)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  specs2 % Test,
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

PlayKeys.playMonitoredFiles ++= (sourceDirectories in(Compile, TwirlKeys.compileTemplates)).value

resolvers ++= Seq(
  "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"
)


    