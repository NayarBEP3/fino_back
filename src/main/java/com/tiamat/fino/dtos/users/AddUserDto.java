package com.tiamat.fino.dtos.users;

import com.tiamat.fino.utils.ValidationUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddUserDto {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String pass;

    public void validate() {
        ValidationUtils.validateMandatory(name, "Error: Name is mandatory");
        ValidationUtils.validateMandatory(lastName, "Error: Lastname is mandatory");
        ValidationUtils.validateMandatory(email, "Error: Email is mandatory");
        ValidationUtils.validateMandatory(pass, "Error: Password is mandatory");
    }
}
