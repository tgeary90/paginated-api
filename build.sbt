name := """paginated-api"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.11"

resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)

// you may also want to add the typesafe repository
//resolvers += "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/"

//libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0"
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % "test",
//  "org.reactivemongo" %% "reactivemongo_2.13" % "1.0.10-noshaded"
  "uk.gov.hmrc" %% "simple-reactivemongo" % "8.0.0-play-28"
)
//resolvers += "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

//libraryDependencies ++= Seq(
//  "org.reactivemongo" %% "reactivemongo" % "0.12.0-SNAPSHOT"
//)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
