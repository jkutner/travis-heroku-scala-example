resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
   url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
       Resolver.ivyStylePatterns)

addSbtPlugin("com.heroku" % "sbt-heroku" % "0.1-dd1e225f069409c1ce0cb27ec768b24cb2cffd27")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.4" excludeAll(ExclusionRule("org.bouncycastle", "*")))

addSbtPlugin("org.jruby" % "sbt-rubygems" % "0.1-SNAPSHOT")

net.virtualvoid.sbt.graph.Plugin.graphSettings
