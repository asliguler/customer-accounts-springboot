package com.acc.customerAPI.repository;

import com.acc.customerAPI.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public long count();
}
