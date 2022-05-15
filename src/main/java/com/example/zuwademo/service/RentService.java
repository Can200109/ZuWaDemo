package com.example.zuwademo.service;

import com.example.zuwademo.entity.Rent;
import com.example.zuwademo.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    public void deleteRent(Rent rent) {
        rent = rentRepository.findByRentId(rent.getRentId());
        rentRepository.delete(rent);
    }

    public List<Rent> findAllRents() {
        return rentRepository.findAll();
    }

    public List<Rent> findRentByPhoneNumber(String phoneNumber) {
        List<Rent> rents = rentRepository.findByPhoneNumber(phoneNumber);
        return rents;
    }

    public Rent addRent(Rent rent) {
        if (rent.getRentId() == null || "".equals(rent.getRentId())) {
            rent.setRentId(UUID.randomUUID().toString());
        }
        return rentRepository.save(rent);
    }
}
