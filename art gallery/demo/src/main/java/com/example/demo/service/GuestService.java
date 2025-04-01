package com.example.demo.service;

import com.example.demo.entity.Guest;
import com.example.demo.Repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepo guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update(Long id, Guest guest) {
        guest.setId(id);
        return guestRepository.save(guest);
    }

    public void delete(Long id) {
        guestRepository.deleteById(id);
    }
}
