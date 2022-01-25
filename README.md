## Prerequisites

- Java 11

- Docker

## Installation

Run in the directory **/spring-cloud-app/doc/docker** the **docker-compose.yml** file is located.

```
docker-compose -f docker-compose.yml up -d
```

Create a keyspace named "**account**".

```cassandraql
create keyspace account with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
```

Create a schema name "**ticket**".
```mysql
create database ticket;
```
## Run

Run microservices in the following order below:
1. config-server
2. eureka-server
3. other services

Note: Be sure docker containers are running and complete installation step.

## Addresses

Eureka Server - http://localhost:8500
![Eureka Server](doc/static/image/eureka-server.png)

Account Service - http://localhost:8501
![Account Service](doc/static/image/account-service.png)

Ticket Service http://localhost:8502
![Ticket Service](doc/static/image/ticket-service.png)

Notification Service - http://localhost:8503

Api Gateway - http://localhost:8504

Admin Server - http://localhost:8505
- Applications - http://localhost:8505/applications
![Applications](doc/static/image/admin-server-applications.png)

- Wallboard - http://localhost:8505/wallboard
![Wallboard](doc/static/image/admin-server-wallboard.png)

Config Server - http://localhost:8888

Zipkin Server - http://localhost:9411
![Zipkin Server](doc/static/image/zipkin-server.png)

Hystrix Dashboard - http://localhost:8080/hystrix
![Hystrix Dashboard](doc/static/image/hystrix-dashboard.png)

Listen Hystrix Stream - Monitor Gateway http://localhost:8504/actuator/hystrix.stream
![Hystrix Stream](doc/static/image/hystrix-strream.png)

ElasticSearch - http://localhost:9200

I used elasticsearch tool box to monitor data.
![ElasticSearch](doc/static/image/elastic-search.png)

RabbitMQ - http://localhost:15672

username: **rabbitmq**<br>
password: **rabbitmq**

![RabbitMQ](doc/static/image/rabbitmq.png)

MySQL - http://localhost:3306 

I used IntelliJ Database Plugin to monitor data.

![MySQL](doc/static/image/mysql.png)

Cassandra - http://localhost:9042

I used IntelliJ Database Plugin to monitor data.

![Cassandra](doc/static/image/cassandra.png)

## License
* [MIT](https://choosealicense.com/licenses/mit/)