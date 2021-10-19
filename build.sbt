
 lazy val root = (project in file("."))
   .settings(
     inThisBuild(List(
       organization := "org.baboci",
       scalaVersion := "2.13.1"
     )),
     libraryDependencies ++= List(
       "org.typelevel" %% "cats-core" % "2.0.0",
       "org.scalactic" %% "scalactic" % "3.2.10",
       "org.scalatest" %% "scalatest" % "3.2.10" % Test
     ),
     name := "scala-exercises"
   )

