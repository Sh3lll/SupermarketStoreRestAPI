package com.example.supermarketstore.service;


import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.SupermarketRepository;
import com.example.supermarketstore.domain.Supermarket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SupermarketService {
     private final SupermarketRepository repository;






    // GET
    public List<Supermarket> getSupermarketItems(){
       return repository.findAll();

    }

    // GET BY ID
    public Supermarket getSupermarketItemById(Long id){
        return repository.findById(id).get();
    }

    // UPDATE
    public SupermarketData updateItem(SupermarketData data, Long id){
        Supermarket supermarket = repository.findById(id).get();
        supermarket.setPrice(data.getPrice());
        supermarket.setDateReceived(data.getDateReceived());

        return SupermarketData.map(repository.save(supermarket));
    }




    // DELETE
    public void deleteSupermarketItem(Long id){
        repository.deleteById(id);
    }

    // GET ITEMS RECEIVED TODAY
    public List<SupermarketData> getItemsReceivedToday(){
        List<SupermarketData> response = new ArrayList<>();
        LocalDate today = LocalDate.now();
        today = LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth());
        List<Supermarket> res = repository.findByDateReceived(today);
        res.forEach(item->response.add(SupermarketData.map(item)));
        return response;
    }
}

