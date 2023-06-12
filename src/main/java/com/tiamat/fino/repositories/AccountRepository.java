package com.tiamat.fino.repositories;

import com.tiamat.fino.entities.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountEntity, String> {
}
