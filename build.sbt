import NativePackagerKeys._

packageArchetype.java_application

name := """scala-getting-started"""

version := "1.0"

//scalaVersion := "2.10.4"

resolvers +=
  "rubygems-release" at "http://rubygems-proxy.torquebox.org/releases"

libraryDependencies ++= Seq(
  "rubygems" % "travis" % "1.7.1" excludeAll(ExclusionRule("rubygems", "pry", "*"), ExclusionRule("rubygems", "ffi", "*")),
  "rubygems" % "pry" % "0.9.12.6",
  "rubygems" % "ffi" % "1.9.3"
)

libraryDependencies ++= Seq(
  "com.twitter" % "finagle-http_2.10" % "6.18.0",
  "postgresql" % "postgresql" % "9.0-801.jdbc4",
  "org.jscience" % "jscience" % "4.3.1"
)

herokuJdkVersion in Compile := "1.8"

//herokuAppName in Compile := (if (sys.props("appName") == null) "sheltered-citadel-3631" else sys.props("appName"))

//herokuJdkUrl in Compile := "http://lang-jvm.s3.amazonaws.com/jdk/openjdk1.8.0_20-slim.tar.gz"

herokuAppName in Compile := Map(
  "test" -> "your-heroku-app-test",
  "stg"  -> "your-heroku-app-stage",
  "prod" -> "your-heroku-app-prod"
).getOrElse(sys.props("appEnv"), "sheltered-citadel-3631")

herokuConfigVars in Compile := Map(
  "JAVA_OPTS" -> "-Dfoobar=$APP_CONFIG -Xmx384m -Xss512k -XX:+UseCompressedOops"
)
