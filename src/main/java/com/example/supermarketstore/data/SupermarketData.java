package com.example.supermarketstore.data;


import com.example.supermarketstore.domain.Supermarket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class SupermarketData {

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("dateReceived")
    private LocalDate dateReceived;

    @JsonProperty("price")
    private Double price;



    public static SupermarketData map(Supermarket supermarket){
        SupermarketData supermarketData = new SupermarketData();
        supermarketData.setItemName(supermarket.getItemName());
        supermarketData.setDateReceived(supermarket.getDateReceived());
        supermarketData.setPrice(supermarket.getPrice());
        return supermarketData;
    }



}
