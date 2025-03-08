package com.cipherx.projects.roomCloud.repository;

import com.cipherx.projects.roomCloud.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
