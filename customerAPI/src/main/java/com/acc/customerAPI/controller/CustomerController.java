package com.acc.customerAPI.controller;

import com.acc.customerAPI.dto.CustomerDTO;
import com.acc.customerAPI.mapper.CustomerMapper;
import com.acc.customerAPI.model.Customer;
import com.acc.customerAPI.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/createNewCustomer")
    public CustomerDTO createNewCustomer(@Valid @RequestBody CustomerDTO dto) {
        Customer customer = customerService.createNewCustomer(dto);
        return CustomerMapper.mapToDTO(customer);
    }

    @PostMapping("/updateCustomerData")
    public CustomerDTO updateCustomerData(@Valid @RequestBody CustomerDTO dto) {
        Customer customer = customerService.updateCustomer(dto);
        return CustomerMapper.mapToDTO(customer);
    }
}
