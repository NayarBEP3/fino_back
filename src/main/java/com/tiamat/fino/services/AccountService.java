package com.tiamat.fino.services;

import com.tiamat.fino.dtos.accounts.AccountDto;
import com.tiamat.fino.dtos.accounts.AddAccountDto;
import com.tiamat.fino.entities.AccountEntity;
import com.tiamat.fino.repositories.AccountRepository;
import com.tiamat.fino.utils.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public AccountService(@Autowired AccountRepository repository) {
        this.repository = repository;
    }

    public AccountDto addAccount(AddAccountDto addAccountDto) {
        addAccountDto.validate();
        AccountEntity accountEntity = mapper.map(addAccountDto, AccountEntity.class);
        accountEntity = repository.save(accountEntity);
        return mapper.map(accountEntity, AccountDto.class);
    }

    public List<AccountDto> getAllAccounts() {
        List<AccountEntity> accountEntities = repository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        accountEntities.forEach(accountEntity -> accountDtos.add(mapper.map(accountEntity, AccountDto.class)));
        return accountDtos;
    }

    public void deleteAccount(String id) {
        repository.deleteById(id);
    }

    public AccountDto updateAccount(AddAccountDto addAccountDto, String accountId) {
        addAccountDto.validate(accountId);
        this.getAccount(accountId);
        AccountEntity accountEntity = mapper.map(addAccountDto, AccountEntity.class);
        accountEntity.setId(accountId);
        accountEntity = repository.save(accountEntity);
        return mapper.map(accountEntity, AccountDto.class);
    }

    public AccountDto getAccount(String accountId) {
        Optional<AccountEntity> accountDto = repository.findById(accountId);
        ValidationUtils.getValueFromOptional(accountDto, "Error: Account not found.");
        return mapper.map(accountDto.get(), AccountDto.class);
    }

}
