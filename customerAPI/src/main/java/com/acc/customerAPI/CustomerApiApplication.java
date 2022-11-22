package com.acc.customerAPI;

import com.acc.customerAPI.repository.AccountRepository;
import com.acc.customerAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CustomerApiApplication {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

}
