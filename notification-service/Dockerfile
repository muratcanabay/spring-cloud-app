FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./notification-service/
WORKDIR  "./notification-service"
ENTRYPOINT ["java", "-jar", "notification-service-0.0.1-SNAPSHOT.jar"]




