package com.tiamat.fino.dtos.accounts;

import com.tiamat.fino.enums.AccountStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String id;
    private String name;
    private AccountStatusEnum status;
    private String userId;
}
