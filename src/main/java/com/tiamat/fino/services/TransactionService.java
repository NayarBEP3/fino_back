package com.tiamat.fino.services;

import com.tiamat.fino.dtos.transactions.AddTransactionDto;
import com.tiamat.fino.dtos.transactions.TransactionDto;
import com.tiamat.fino.entities.AccountEntity;
import com.tiamat.fino.entities.TransactionEntity;
import com.tiamat.fino.repositories.AccountRepository;
import com.tiamat.fino.repositories.TransactionRepository;
import com.tiamat.fino.utils.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper mapper = new ModelMapper();

    public TransactionService(@Autowired TransactionRepository transactionRepository,
                              @Autowired AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public TransactionDto createTransaction(AddTransactionDto addTransactionDto) {
        TransactionEntity transactionEntity = mapper.map(addTransactionDto, TransactionEntity.class);
        AccountEntity accountEntity = getAccountEntityById(addTransactionDto.getAccountId());
        transactionEntity.setAccount(accountEntity);
        transactionEntity = transactionRepository.save(transactionEntity);
        return mapper.map(transactionEntity, TransactionDto.class);
    }

    public TransactionDto getTransactionById(String id) {
        Optional<TransactionEntity> transaction = transactionRepository.findById(id);
        ValidationUtils.validateMandatory(transaction, "Error: Transaction doesn't exist");
        return mapper.map(transaction.get(), TransactionDto.class);
    }

    private AccountEntity getAccountEntityById(String id) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(id);
        ValidationUtils.validateMandatory(accountEntity, "Error: Account doesn't exist.");
        return accountEntity.get();
    }
}