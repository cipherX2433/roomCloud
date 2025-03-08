package com.cipherx.projects.roomCloud.repository;

import com.cipherx.projects.roomCloud.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
