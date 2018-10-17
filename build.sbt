name := """Ontologies"""
organization := "ncsu"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

libraryDependencies += guice

libraryDependencies += "com.github.galigator.openllet" % "openllet-jena" % "2.6.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7"

//adding json library for the json.

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.3.4"

libraryDependencies += javaForms

libraryDependencies += javaJdbc


libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.23.1"