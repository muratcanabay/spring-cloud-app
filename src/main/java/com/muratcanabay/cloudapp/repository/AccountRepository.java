package com.muratcanabay.cloudapp.repository;

import com.muratcanabay.cloudapp.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
}
