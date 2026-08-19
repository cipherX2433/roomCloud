package com.cipherx.projects.roomCloud.controller;

import com.cipherx.projects.roomCloud.dto.RoomDto;
import com.cipherx.projects.roomCloud.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
@Tag(name = "Room Management (Admin)", description = "Hotel room creation, configuration, listing, and deletion")
public class RoomAdminController {

    private final RoomService roomService;

    @PostMapping
    @Operation(summary = "Create new room in hotel", description = "Creates a new room type/entry for the specified hotel.")
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId,
                                                 @RequestBody RoomDto roomDto) {
        RoomDto room = roomService.createNewRoom(hotelId, roomDto);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all rooms in hotel", description = "Lists all room types configured for the given hotel.")
    public ResponseEntity<List<RoomDto>> getAllRoomsInHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getAllRoomsInHotel(hotelId));
    }

    @GetMapping("/{roomId}")
    @Operation(summary = "Get room by ID", description = "Retrieves room details by room ID.")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long hotelId, @PathVariable Long roomId) {
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @DeleteMapping("/{roomId}")
    @Operation(summary = "Delete room by ID", description = "Deletes a room configuration from the hotel.")
    public ResponseEntity<RoomDto> deleteRoomById(@PathVariable Long hotelId, @PathVariable Long roomId) {
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{roomId}")
    @Operation(summary = "Update room by ID", description = "Updates details of a room in the specified hotel.")
    public ResponseEntity<RoomDto> updateRoomById(@PathVariable Long hotelId, @PathVariable Long roomId,
                                                  @PathVariable RoomDto roomDto){
        return ResponseEntity.ok(roomService.updateRoomById(hotelId, roomId, roomDto));
    }

}