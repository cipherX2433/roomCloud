package com.cipherx.projects.roomCloud.dto;

import com.cipherx.projects.roomCloud.entity.enums.Role;
import lombok.Data;

@Data
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private Role role;
}
