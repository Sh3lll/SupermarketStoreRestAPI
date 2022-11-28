package com.example.supermarketstore.api;


import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.Supermarket;
import com.example.supermarketstore.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor

public class SupermarketController {

    private final SupermarketService service;



    // FETCH ALL
    @GetMapping("/supermarket_item")
    public @ResponseBody List<Supermarket> fetchSupermarketItems(){
        return service.getSupermarketItems();
    }

    // FETCH BY ID
    @GetMapping("/supermarket_item/{id}")
    public Supermarket getSupermarketItemById(@PathVariable Long id){
        return service.getSupermarketItemById(id);

    }

    // UPDATE
    @PutMapping("/supermarket_item/{id}")
    public @ResponseBody
    SupermarketData updateSupermarket(@PathVariable(name = "id") Long id,
                        @RequestBody  SupermarketData data) {
        return service.updateItem(data, id);
    }

    // DELETE
    @DeleteMapping("/supermarket_item/{id}")
    public void deleteSupermarketItem(@PathVariable Long id){
        service.deleteSupermarketItem(id);
    }

    // GET ITEMS CREATED TODAY
    @GetMapping("/supermarket_item/createdToday")
    public List<SupermarketData> getItemsReceivedToday( ){
        return service.getItemsReceivedToday();
    }
}
