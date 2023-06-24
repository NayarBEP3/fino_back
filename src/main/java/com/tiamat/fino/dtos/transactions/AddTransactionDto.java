package com.tiamat.fino.dtos.transactions;

import com.tiamat.fino.enums.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTransactionDto {
    private String description;
    private double amount;
    private TransactionTypeEnum transactionType;
    private String accountId;
}