package com.acc.customerAPI.mapper;

import com.acc.customerAPI.dto.CustomerDTO;
import com.acc.customerAPI.model.Customer;

public final class CustomerMapper {
    public static CustomerDTO mapToDTO(Customer model) {
        return new CustomerDTO(model.getId(), model.getName(), model.getSurname(), model.getEmail());
    }

    public static Customer mapToModel(CustomerDTO dto) {
        return new Customer(dto.getName(), dto.getSurname(), dto.getEmail());
    }
}
