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
    private String user;

    public void validate() {
        ValidationUtils.validateMandatory(this.name, "Error: Account name is mandatory");
        ValidationUtils.validateMandatory(this.user, "Error: User Id is mandatory");
    }

    public void validate(String account) {
        ValidationUtils.validateMandatory(account, "Error: Account id is mandatory");
        ValidationUtils.validateMandatory(this.name, "Error: Account name is mandatory");
        ValidationUtils.validateMandatory(this.user, "Error: User Id is mandatory");
    }

}
