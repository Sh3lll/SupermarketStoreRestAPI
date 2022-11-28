package com.example.supermarketstore.data;

import com.example.supermarketstore.domain.Store;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class StoreData {

    @JsonProperty("id")
    private Long Id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("dateProcured")
    private LocalDate dateProcured;

    @JsonProperty("vendorId")
    private Long vendorId;

    @JsonProperty("location")
    private String location;

    public static Store map(StoreData data){
        Store store = new Store();
        store.setItemName(data.getItemName());
        store.setDateProcured(data.getDateProcured());
        store.setLocation(data.getLocation());
        return store;
    }

    public static StoreData map(Store store){
        StoreData data = new StoreData();
        data.setId(store.getId());
        data.setItemName(store.getItemName());
        data.setDateProcured(store.getDateProcured());
        data.setVendorId(store.getVendor().getId());
        data.setLocation(store.getLocation());
        return data;
    }

}
