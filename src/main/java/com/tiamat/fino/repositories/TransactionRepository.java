package com.tiamat.fino.repositories;

import com.tiamat.fino.entities.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
    List<TransactionEntity> getTransactionByAccount(String accountId);
}
