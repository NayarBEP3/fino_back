package com.tiamat.fino.entities;

import com.tiamat.fino.enums.AccountStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class AccountEntity {
    @Id
    private String id;
    private String name;
    private AccountStatusEnum status;
    private String userId;
}
