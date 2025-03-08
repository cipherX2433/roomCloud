package com.cipherx.projects.roomCloud.service;

import com.cipherx.projects.roomCloud.dto.ProfileUpdateRequestDto;
import com.cipherx.projects.roomCloud.dto.UserDto;
import com.cipherx.projects.roomCloud.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
