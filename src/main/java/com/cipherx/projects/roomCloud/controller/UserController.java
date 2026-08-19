package com.cipherx.projects.roomCloud.controller;

import com.cipherx.projects.roomCloud.dto.BookingDto;
import com.cipherx.projects.roomCloud.dto.ProfileUpdateRequestDto;
import com.cipherx.projects.roomCloud.dto.UserDto;
import com.cipherx.projects.roomCloud.service.BookingService;
import com.cipherx.projects.roomCloud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Profile & Bookings", description = "Endpoints for logged-in user profile management and personal booking history")
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;

    @PatchMapping("/profile")
    @Operation(summary = "Update user profile", description = "Updates profile information (e.g., name, gender, date of birth) for the logged-in user.")
    public ResponseEntity<Void> updateProfile(@RequestBody ProfileUpdateRequestDto profileUpdateRequestDto){
        userService.updateProfile(profileUpdateRequestDto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/myBookings")
    @Operation(summary = "Get user bookings", description = "Retrieves all hotel bookings created by the currently authenticated user.")
    public ResponseEntity<List<BookingDto>> getMyBookings(){
        return ResponseEntity.ok(bookingService.getMyBookings());
    }

    @GetMapping("/profile")
    @Operation(summary = "Get user profile", description = "Retrieves profile details of the currently authenticated user.")
    public ResponseEntity<UserDto> getMyProfile(){
        return ResponseEntity.ok(userService.getMyProfile());
    }
}

