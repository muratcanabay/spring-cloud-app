## Prerequisites

- Java 11

- Docker

## Installation

Run it to start [cassandra](https://cassandra.apache.org/) database in the directory where the **docker-compose.yml** file is located.

```
docker-compose -f docker-compose.yml up -d
```

Create a keyspace named "**account**".

```cassandraql
create keyspace account with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
```

## License
* [MIT](https://choosealicense.com/licenses/mit/)