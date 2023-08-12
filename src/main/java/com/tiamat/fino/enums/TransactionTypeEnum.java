package com.tiamat.fino.enums;

public enum TransactionTypeEnum {
    INCOME,
    EXPENSE,
    TRANSFER;

    public static boolean isValid(String name) {
        for (TransactionTypeEnum transactionType : values()) {
            if(transactionType.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
