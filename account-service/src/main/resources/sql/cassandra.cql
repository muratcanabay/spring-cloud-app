-- Default username: cassandra password: cassandra

create keyspace account with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

use account;

select * from account.accounts;