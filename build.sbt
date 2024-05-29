name := "scala-training"

version := "0.1.0"

scalaVersion := "3.3.3"

val sparkVersion = "3.5.1"
libraryDependencies ++= Seq(
  ("org.apache.spark" %% "spark-core" % sparkVersion % "provided")
    .cross(CrossVersion.for3Use2_13) ,
  ("org.apache.spark" %% "spark-sql" % sparkVersion % "provided")
    .cross(CrossVersion.for3Use2_13) ,
  ("org.apache.spark" %% "spark-hive" % sparkVersion % "provided")
    .cross(CrossVersion.for3Use2_13) ,
  "com.typesafe" % "config" % "1.4.3",
  ("org.scalatest" %% "scalatest" % "3.3.3" % "test")
    .cross(CrossVersion.for3Use2_13),
//  ("org.scalactic" %% "scalactic" % "3.3.3" % "test")
//    .cross(CrossVersion.for3Use2_13),
)

assembly / assemblyMergeStrategy := {
  case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
