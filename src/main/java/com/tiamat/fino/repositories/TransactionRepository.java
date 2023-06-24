package com.tiamat.fino.repositories;

import com.tiamat.fino.entities.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
}
