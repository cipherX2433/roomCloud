package com.cipherx.projects.roomCloud.dto;

import com.cipherx.projects.roomCloud.entity.User;
import com.cipherx.projects.roomCloud.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;

}
