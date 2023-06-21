package com.tiamat.fino.dtos.accounts;


import com.tiamat.fino.enums.AccountStatusEnum;
import com.tiamat.fino.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAccountDto {
    private String name;
    private AccountStatusEnum status;
    private String userId;

    public void validate() {
        ValidationUtils.validateMandatory(this.name, "Error: Account name is mandatory");
        ValidationUtils.validateMandatory(this.userId, "Error: User Id is mandatory");
    }

}
