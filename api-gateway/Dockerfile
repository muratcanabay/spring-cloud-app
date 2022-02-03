FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./api-gateway/
WORKDIR  "./api-gateway"
ENTRYPOINT ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]




