FROM openjdk:8-jdk-alpine
COPY target/personalrest-0.0.1-SNAPSHOT.jar personalrest-server-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/personalrest-server-0.0.1.jar"]
