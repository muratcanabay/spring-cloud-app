package com.mabay.accountservice.api;

import com.mabay.accountservice.dto.AccountDto;
import com.mabay.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable String id, @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.update(id, accountDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Slice<AccountDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.findAll(pageable));
    }

}
