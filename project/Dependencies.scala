import sbt._
object Dependencies {
  object Versions {
    val akka = "2.5.7"
    val akkaHttp = "10.0.11"
  }

  val production = Seq(
    "com.github.nscala-time" %% "nscala-time" % "2.20.0",
    "com.lihaoyi"            %% "pprint"      % "0.5.3"
  )
  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    "org.scalamock" %% "scalamock" % "4.1.0" % Test
  )

}
