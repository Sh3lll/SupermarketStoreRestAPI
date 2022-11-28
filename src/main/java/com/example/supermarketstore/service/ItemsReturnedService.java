package com.example.supermarketstore.service;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.domain.ItemsReturned;
import com.example.supermarketstore.domain.ItemsReturnedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ItemsReturnedService {
    private final ItemsReturnedRepository repository;



    // CREATE
    public ItemsReturnedData createItemReturned(ItemsReturnedData data){
        ItemsReturned itemsReturned = ItemsReturnedData.map(data);
        return ItemsReturnedData.map(repository.save(itemsReturned));
    }

    // GET
    public List<ItemsReturnedData> getItemsReturned(){
        List<ItemsReturnedData> response = new ArrayList<>();
        repository.findAll().forEach(item ->
            response.add(ItemsReturnedData.map(item))
        );
        return response;
    }

    // GET BY ID
    public ItemsReturnedData getItemsReturnedById(Long id){
        return ItemsReturnedData.map(repository.findById(id).get());
    }

    // GET ITEMS RETURNED BY DATE
    public List<ItemsReturnedData> getItemsReturnedByDateRange(LocalDate startDate, LocalDate endDate){
        List<ItemsReturnedData> response = new ArrayList<>();
        LocalDate startDate2 = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
        LocalDate endDate2 = LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());

        List<ItemsReturned> itemsReturned = repository.findByDateReturnedBetween(startDate2, endDate2);

        itemsReturned.forEach(item->response.add(ItemsReturnedData.map(item)));
        return response;
    }



    // DELETE
    public void deleteItemReturned(Long id){
        repository.deleteById(id);
    }
}
