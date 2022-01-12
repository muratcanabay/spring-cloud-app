package com.mabay.accountservice.service;

import com.mabay.accountservice.entity.Account;
import com.mabay.accountservice.repository.AccountRepository;
import com.mabay.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDto get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.notNull(id, "Id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
        Account updatedAccount = account.map(item -> {
            item.setName(accountDto.getName());
            item.setSurname(accountDto.getSurname());
            item.setBirthDate(accountDto.getBirthDate());
            return item;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(accountRepository.save(updatedAccount), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        accountRepository.delete(accountRepository.findById(id).orElseThrow(IllegalAccessError::new));
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
        return modelMapper.map(accountRepository.findAll(pageable), Slice.class);
    }
}
