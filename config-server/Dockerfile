FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./config-server/
WORKDIR  "./config-server"
ENTRYPOINT ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]




