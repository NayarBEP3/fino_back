package com.tiamat.fino.controllers;

import com.tiamat.fino.dtos.accounts.AccountDto;
import com.tiamat.fino.dtos.accounts.AddAccountDto;
import com.tiamat.fino.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService service;

    public AccountController(@Autowired AccountService service) {
        this.service = service;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto addAccount(@RequestBody AddAccountDto addAccountDto) {
        return service.addAccount(addAccountDto);
    }

    @GetMapping(path = "/all")
    public List<AccountDto> getAccounts() {
        return service.getAllAccounts();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAccount(@PathVariable String id) {
        service.deleteAccount(id);
    }

    @GetMapping(path = "/{id}")
    public AccountDto getAccount(@PathVariable String id) {
        return service.getAccount(id);
    }

    @PutMapping(path = "/update/{id}")
    public AccountDto updateAccount(@PathVariable String id, @RequestBody AddAccountDto addAccountDto) {
        return service.updateAccount(addAccountDto, id);
    }
}
