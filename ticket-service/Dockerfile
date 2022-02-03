FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./ticket-service/
WORKDIR  "./ticket-service"
ENTRYPOINT ["java", "-jar", "ticket-service-0.0.1-SNAPSHOT.jar"]




