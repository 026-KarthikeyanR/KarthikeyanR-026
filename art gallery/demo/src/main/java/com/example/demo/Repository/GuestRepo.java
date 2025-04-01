package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Guest;

public interface GuestRepo extends JpaRepository<Guest, Long> {

    // Find guests by name
    // List<Guest> findByGuestName(String guestName);

    // // Find guests by email
    // List<Guest> findByEmail(String email);

    // Find guests attending a specific event
    // @Query("SELECT g FROM Guest g WHERE g.event.id = :eventId")
    // List<Guest> findGuestsByEvent(@Param("eventId") Long eventId);
}
