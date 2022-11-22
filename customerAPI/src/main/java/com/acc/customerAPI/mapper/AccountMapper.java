package com.acc.customerAPI.mapper;

import com.acc.customerAPI.dto.AccountDTO;
import com.acc.customerAPI.model.Account;

public final class AccountMapper {
    public static AccountDTO mapToDTO(Account model){
        return new AccountDTO(model.getId(), model.getCustomer(), model.getBalance(), model.getCurrency());
    }

    public static Account mapToModel(AccountDTO dto) {
        return new Account(dto.getCustomer(), dto.getBalance(), dto.getCurrency());
    }
}
