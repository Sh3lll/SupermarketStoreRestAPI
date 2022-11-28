package com.example.supermarketstore.service;


import com.example.supermarketstore.domain.Vendor;
import com.example.supermarketstore.domain.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class VendorService {

    private final VendorRepository repository;


    // CREATE
    public Vendor createVendor(Vendor vendor){
        return repository.save(vendor);
    }

    //GET ALL
    public List<Vendor> getVendors(){
        return repository.findAll();
    }

    //GET BY ID
    public Vendor getVendorById(Long id){
        return repository.findById(id).get();
    }

    //DELETE
    public void deleteVendor(Long id){
        repository.deleteById(id);
    }

    //UPDATE
    public Vendor updateVendor(Vendor vendor, Long id){
        Vendor records = repository.findById(id).get();
        records.setVendorName(vendor.getVendorName());
        return repository.save(records);
    }


}
