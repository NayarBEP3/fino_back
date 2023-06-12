package com.tiamat.fino.services;

import com.tiamat.fino.dtos.accounts.AccountDto;
import com.tiamat.fino.dtos.accounts.AddAccountDto;
import com.tiamat.fino.entities.AccountEntity;
import com.tiamat.fino.repositories.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
