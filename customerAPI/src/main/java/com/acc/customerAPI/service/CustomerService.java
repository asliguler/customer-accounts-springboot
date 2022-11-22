package com.acc.customerAPI.service;

import com.acc.customerAPI.dto.CustomerDTO;
import com.acc.customerAPI.mapper.CustomerMapper;
import com.acc.customerAPI.model.Customer;
import com.acc.customerAPI.repository.CustomerRepository;
import com.acc.customerAPI.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public Customer createNewCustomer(CustomerDTO dto) {
        Customer model = CustomerMapper.mapToModel(dto);
        return customerRepository.save(model);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> modelList = customerRepository.findAll();
        List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();
        if (Utility.isNotNullOrEmpty(modelList)) {
            for (Customer model : modelList) {
                CustomerDTO dto = CustomerMapper.mapToDTO(model);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return Collections.emptyList();
    }

    public Customer updateCustomer(CustomerDTO dto) {
        Optional<Customer> customer = customerRepository.findById(dto.getId());
        if (customer.isPresent()) {
            Customer model = customer.get();
            if (Utility.isNotNullOrEmpty(dto.getName())) {
                model.setName(dto.getName());
            }
            if (Utility.isNotNullOrEmpty(dto.getSurname())) {
                model.setSurname(dto.getSurname());
            }
            if (Utility.isNotNullOrEmpty(dto.getEmail())) {
                model.setEmail(dto.getEmail());
            }
            return customerRepository.save(model);
        }
        return null;
    }
}
