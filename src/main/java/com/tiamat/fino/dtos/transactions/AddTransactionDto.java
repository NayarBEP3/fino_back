package com.tiamat.fino.dtos.transactions;

import com.tiamat.fino.enums.TransactionTypeEnum;
import com.tiamat.fino.utils.ValidationUtils;
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
    private String account;

    public void validate() {
        ValidationUtils.validateMandatory(this.amount, "Error: Amount is mandatory.");
        ValidationUtils.validateMandatory(this.account, "Error: Account is mandatory.");
        ValidationUtils.isValid(TransactionTypeEnum.isValid(transactionType.name()), "Error: Transaction Type doesn't exist.");
    }
}
