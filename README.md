## Prerequisites

- Java 11

- Docker

## Installation

Run in the directory where the **docker-compose.yml** file is located.

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

## Addresses

Eureka Server localhost:8500


Account Service localhost:8501


Ticket Service localhost:8502


Notification Service localhost:8503


Api Gateway localhost:8504


Admin Server localhost:8505


## License
* [MIT](https://choosealicense.com/licenses/mit/)