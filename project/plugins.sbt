//resolvers += "local-maven-releases" at "file:///Users/jkutner/.m2/repository"
resolvers += Resolver.url("heroku-sbt-plugin-releases",
  url("https://dl.bintray.com/heroku/sbt-plugins/"))(Resolver.ivyStylePatterns)


addSbtPlugin("com.heroku" % "sbt-heroku" % "0.3.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.6" excludeAll(ExclusionRule("org.bouncycastle", "*")))

addSbtPlugin("org.jruby" % "sbt-rubygems" % "1.0")

//net.virtualvoid.sbt.graph.Plugin.graphSettings
