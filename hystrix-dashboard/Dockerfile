FROM openjdk:11
MAINTAINER muratcanabay.com

COPY ./target ./hystrix-dashboard/
WORKDIR  "./hystrix-dashboard"
ENTRYPOINT ["java", "-jar", "hystrix-dashboard-0.0.1-SNAPSHOT.jar"]




