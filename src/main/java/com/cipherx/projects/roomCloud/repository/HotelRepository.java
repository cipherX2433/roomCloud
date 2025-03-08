package com.cipherx.projects.roomCloud.repository;

import com.cipherx.projects.roomCloud.entity.Hotel;
import com.cipherx.projects.roomCloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
