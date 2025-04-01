package com.example.demo.controller;

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAll() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable Long id) {
        Guest guest = guestService.getGuestById(id);
        return guest != null ? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Guest create(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable Long id, @RequestBody Guest guest) {
        Guest updatedGuest = guestService.update(id, guest);
        return ResponseEntity.ok(updatedGuest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
