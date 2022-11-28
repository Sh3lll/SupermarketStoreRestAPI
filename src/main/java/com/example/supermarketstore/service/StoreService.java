package com.example.supermarketstore.service;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.data.StoreData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StoreService {
    private final StoreRepository repository;
    private final VendorService vendorService;

    private final ItemsReturnedRepository itemsReturnedRepository;

    private final SupermarketRepository supermarketRepository;

    // CREATE
    public StoreData createItem(StoreData data){
        Store store = StoreData.map(data);
        if(data.getVendorId() !=null){
            store.setVendor(vendorService.getVendorById(data.getVendorId()));
        }

        return StoreData.map(repository.save(store));
    }

    // GET
    public List<StoreData> getItems(){
            List<StoreData> response = new ArrayList<>();
            repository.findAll().forEach(item ->
            response.add(StoreData.map(item))
         );
        return response;
    }

    // GET BY DATE
  public List<StoreData> getItemsByDateRange(LocalDate startDate, LocalDate endDate){
        List<StoreData> response = new ArrayList<>();
        LocalDate startDate2 = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
        LocalDate endDate2 = LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());

      List<Store> store = repository.findByDateProcuredBetween(startDate2, endDate2);

        store.forEach(item->response.add(StoreData.map(item)));
        return response;
  }

  // GET ITEMS CREATED TODAY
    public List<StoreData> getItemsCreatedToday(){
        List<StoreData> response = new ArrayList<>();
        LocalDate today = LocalDate.now();
        today = LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth());
        List<Store> res = repository.findByDateProcured(today);
        res.forEach(item->response.add(StoreData.map(item)));
        return response;
    }

    // GET BY ID
    public StoreData getItemById(Long id){
        return StoreData.map(repository.findById(id).get());
    }

    // UPDATE
    public StoreData updateItem(StoreData data, Long id){
        Store store = repository.findById(id).get();
        store.setItemName(data.getItemName());
        store.setDateProcured(data.getDateProcured());
        if(data.getVendorId() !=null){
            store.setVendor(vendorService.getVendorById(data.getVendorId()));
        }

        return StoreData.map(repository.save(store));
    }


    // DELETE
    public void deleteItem(Long id){
        repository.deleteById(id);
    }

    public Supermarket releaseItem(SupermarketData data, Long id){
        Store item = repository.findById(id).get();
        Supermarket newData = new Supermarket();
        newData.setPrice(data.getPrice());
        newData.setDateReceived(data.getDateReceived());
        newData.setItemName(item.getItemName());

        item.setLocation("supermarket");

        repository.save(item);
        supermarketRepository.save(newData);
        return newData;
    }

    public ItemsReturnedData returnItemsToVendor(ItemsReturnedData data, Long id){

        Store item = repository.findById(id).get();

        ItemsReturned newData = new ItemsReturned();
        newData.setDateReturned(data.getDateReturned());
        newData.setStore(item);
        newData.setVendor(vendorService.getVendorById(item.getVendor().getId()));
        newData.setItemName(item.getItemName());
        item.setLocation("vendor");

        repository.save(item);
        itemsReturnedRepository.save(newData);
        return ItemsReturnedData.map(newData);
    }

}
