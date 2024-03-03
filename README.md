# altice
This repo is for the implementation of an exercise for altice

nome-do-projeto
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

Running the application in dev mode
You can run your application in dev mode that enables live coding using:

./mvnw compile quarkus:dev
NOTE: Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

After the application is running
You can go to this URL: http://localhost:8080/swagger-ui/ where you will find the endpoint of the exercise, and can test it.

Packaging and running the application
The application can be packaged using:

./mvnw package
It produces the quarkus-run.jar file in the target/quarkus-app/ directory. Be aware that it’s not an über-jar as the dependencies are copied into the target/quarkus-app/lib/ directory.

The application is now runnable using java -jar target/quarkus-app/quarkus-run.jar.

If you want to build an über-jar, execute the following command:

./mvnw package -Dquarkus.package.type=uber-jar
The application, packaged as an über-jar, is now runnable using java -jar target/*-runner.jar.

Creating a native executable
You can create a native executable using:

./mvnw package -Dnative
Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

./mvnw package -Dnative -Dquarkus.native.container-build=true
You can then execute your native executable with: ./target/nome-do-projeto-1.0.0-SNAPSHOT-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

Provided Code
RESTEasy Reactive
Easily start your Reactive RESTful Web Services

Related guide section...
