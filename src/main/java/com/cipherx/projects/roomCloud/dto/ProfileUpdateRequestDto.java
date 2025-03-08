package com.cipherx.projects.roomCloud.dto;

import com.cipherx.projects.roomCloud.entity.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUpdateRequestDto {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
