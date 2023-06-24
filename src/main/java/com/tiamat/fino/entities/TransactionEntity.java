package com.tiamat.fino.entities;

import com.tiamat.fino.enums.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class TransactionEntity {
    @Id
    private String id;
    private String description;
    private double amount;
    private TransactionTypeEnum transactionType;
    private AccountEntity account;
}
