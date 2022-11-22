package com.acc.customerAPI.controller;

import com.acc.customerAPI.dto.AccountDTO;
import com.acc.customerAPI.dto.TransferBalanceDTO;
import com.acc.customerAPI.mapper.AccountMapper;
import com.acc.customerAPI.model.Account;
import com.acc.customerAPI.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/createAccount")
    public AccountDTO createAccountForCustomer(@RequestBody AccountDTO dto) {
        Account account = accountService.createAccountForCustomer(dto);
        return AccountMapper.mapToDTO(account);
    }

    @GetMapping("/getAccountsOfAUser/{customer}")
    public List<AccountDTO> getAccountsofAUser(@PathVariable String customer) {
        List<Account> accountList = accountService.getAccountsOfACustomer(customer);
        List<AccountDTO> accountDTOList = new ArrayList<AccountDTO>();
        for (Account account : accountList) {
            AccountDTO dto = AccountMapper.mapToDTO(account);
            accountDTOList.add(dto);
        }
        return accountDTOList;
    }

    @DeleteMapping("/removeAccount/{id}")
    public void removeAccount(@PathVariable String id) {
        accountService.removeAccount(id);
    }

    @PostMapping("/transferBalance")
    public String transferBalance(@RequestBody TransferBalanceDTO dto) {
        return accountService.transferBalanceBetweenAccounts(dto);
    }
}
