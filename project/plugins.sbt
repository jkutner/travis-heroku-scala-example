addSbtPlugin("com.heroku" % "sbt-heroku" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.6" excludeAll(ExclusionRule("org.bouncycastle", "*")))

addSbtPlugin("org.jruby" % "sbt-rubygems" % "1.0")

//net.virtualvoid.sbt.graph.Plugin.graphSettings
