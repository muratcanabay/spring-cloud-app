package com.muratcanabay.cloudapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring-cloud.cassandra.contact-point}")
    private String contactPoint;

    @Value("${spring-cloud.cassandra.port}")
    private int port;

    @Value("${spring-cloud.cassandra.keyspace}")
    private String keyspace;

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

}
