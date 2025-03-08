package com.cipherx.projects.roomCloud.dto;

import com.cipherx.projects.roomCloud.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomPriceDto {
    private Room room;
    private Double price;
}
