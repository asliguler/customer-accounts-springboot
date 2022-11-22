package com.acc.customerAPI.repository;

import com.acc.customerAPI.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    @Query("{customer:'?0'}")
    List<Account> findAccountsByCustomer(String customer);

    public long count();
}
