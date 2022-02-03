FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./account-service/
WORKDIR  "./account-service"
ENTRYPOINT ["java", "-jar", "account-service-0.0.1-SNAPSHOT.jar"]




