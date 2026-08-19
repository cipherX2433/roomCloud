package com.cipherx.projects.roomCloud.controller;

import com.cipherx.projects.roomCloud.dto.InventoryDto;
import com.cipherx.projects.roomCloud.dto.UpdateInventoryRequestDto;
import com.cipherx.projects.roomCloud.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/inventory")
@RequiredArgsConstructor
@Tag(name = "Inventory Management (Admin)", description = "Manage room availability, inventory, and surge/dynamic pricing parameters")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/rooms/{roomId}")
    @Operation(summary = "Get room inventory", description = "Retrieves all inventory entries and date-wise availability for a specific room.")
    public ResponseEntity<List<InventoryDto>> getAllInventoryByRoom(@PathVariable Long roomId){
        return ResponseEntity.ok(inventoryService.getAllInventoryByRoom(roomId));
    }

    @PatchMapping("/rooms/{roomId}")
    @Operation(summary = "Update room inventory", description = "Updates room capacity, availability, or pricing rules for a date range.")
    public ResponseEntity<Void> updateInventory(@PathVariable Long roomId,
                                                @RequestBody UpdateInventoryRequestDto updateInventoryRequestDto){
        inventoryService.updateInventory(roomId, updateInventoryRequestDto);
        return ResponseEntity.noContent().build();
    }
}

