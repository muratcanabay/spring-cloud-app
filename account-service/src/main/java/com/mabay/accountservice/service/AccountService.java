package com.mabay.accountservice.service;

import com.mabay.accountservice.entity.Account;
import com.mabay.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(String id, Account account) {
        Assert.notNull(id, "Id cannot be null");
        return accountRepository.save(account);
    }

    public void delete(String id) {
        accountRepository.delete(accountRepository.findById(id).orElseThrow(IllegalAccessError::new));
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
