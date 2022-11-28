package com.example.supermarketstore.data;

import com.example.supermarketstore.domain.ItemsReturned;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ItemsReturnedData {

    private Long id;

    private Long storeId;

    private Long vendorId;

    private LocalDate dateReturned;

    public static ItemsReturned map(ItemsReturnedData data){
        ItemsReturned itemsReturned = new ItemsReturned();
        itemsReturned.setDateReturned(data.getDateReturned());
        return itemsReturned;
    }

    public static ItemsReturnedData map(ItemsReturned itemsReturned){
        ItemsReturnedData data = new ItemsReturnedData();
        data.setId(itemsReturned.getId());
        data.setStoreId(itemsReturned.getStore().getId());
        data.setVendorId(itemsReturned.getVendor().getId());
        data.setDateReturned(itemsReturned.getDateReturned());
        return data;
    }
}
