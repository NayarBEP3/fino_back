package com.tiamat.fino.dtos.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String lastName;
    private String email;
}
