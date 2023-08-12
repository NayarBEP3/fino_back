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

import java.util.ArrayList;
import java.util.List;
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
        addTransactionDto.validate();
        TransactionEntity transactionEntity = mapper.map(addTransactionDto, TransactionEntity.class);
        this.getAccountEntityById(addTransactionDto.getAccount());
        transactionEntity = transactionRepository.save(transactionEntity);
        return mapper.map(transactionEntity, TransactionDto.class);
    }

    public TransactionDto getTransactionById(String id) {
        Optional<TransactionEntity> transaction = transactionRepository.findById(id);
        ValidationUtils.validateMandatory(transaction, "Error: Transaction doesn't exist");
        return mapper.map(transaction.get(), TransactionDto.class);
    }

    public List<TransactionDto> getAllTransactionsByAccountId(String id) {
        List<TransactionEntity> transactionEntities = transactionRepository.getTransactionByAccount(id);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactionEntities.forEach(transactionEntity ->
                transactionDtos.add(mapper.map(transactionEntity, TransactionDto.class)));
        return transactionDtos;
    }

    private void getAccountEntityById(String id) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(id);
        ValidationUtils.validateMandatory(accountEntity, "Error: Account doesn't exist.");
    }

}