package com.zw.jimfish.Smart.School.Management.System.SSMS.model.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private String phone;
    private String address;
}
