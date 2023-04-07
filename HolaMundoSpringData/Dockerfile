FROM openjdk:20
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/HolaSpring-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]