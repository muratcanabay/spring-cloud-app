FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./eureka-server/
WORKDIR  "./eureka-server"
ENTRYPOINT ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]




