package com.acc.customerAPI.service;

import com.acc.customerAPI.dto.AccountDTO;
import com.acc.customerAPI.dto.TransferBalanceDTO;
import com.acc.customerAPI.mapper.AccountMapper;
import com.acc.customerAPI.model.Account;
import com.acc.customerAPI.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccountForCustomer(AccountDTO dto) {
        Account model = AccountMapper.mapToModel(dto);
        return accountRepository.save(model);
    }

    public List<Account> getAccountsOfACustomer(String customer) {
        return accountRepository.findAccountsByCustomer(customer);
    }

    public void removeAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

    public String transferBalanceBetweenAccounts(TransferBalanceDTO dto) {
        Optional<Account> sourceAccountOptional = accountRepository.findById(dto.getSourceAccountId());
        Optional<Account> destinationAccountOptional = accountRepository.findById(dto.getDestinationAccountId());
        boolean transferBetweenDifferentUsers = false;
        if (!sourceAccountOptional.isPresent()) {
            return "Source account does not exists";
        }
        if (!destinationAccountOptional.isPresent()) {
            return "Destination account does not exists";
        }
        Account sourceAccount = sourceAccountOptional.get();
        Account destinationAccount = destinationAccountOptional.get();
        if(sourceAccount.getCurrency() != null && !sourceAccount.getCurrency().equals(destinationAccount.getCurrency())) {
            return "Source and destination currencies does not match";

        }
        if(sourceAccount.getBalance() == null || destinationAccount.getBalance() == null) {
            return "Source or destination balance does not exists";
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - dto.getTransferAmount());
        destinationAccount.setBalance(destinationAccount.getBalance() + dto.getTransferAmount());
        transferBetweenDifferentUsers = sourceAccount.getCustomer() != null && sourceAccount.getCustomer().equals(destinationAccount.getCustomer());
        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);
        if (!transferBetweenDifferentUsers) {
            return "Transfer completed between different users";
        }
        return "Transfer completed.";
    }


}
