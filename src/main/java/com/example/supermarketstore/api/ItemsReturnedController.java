package com.example.supermarketstore.api;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.service.ItemsReturnedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class ItemsReturnedController {

    private final ItemsReturnedService service;

    // POST
    @PostMapping("/items_returned")
    public ItemsReturnedData createItemReturned(@RequestBody ItemsReturnedData data){
        return service.createItemReturned(data);
    }

    // FETCH ALL
    @GetMapping("/items_returned")
    public @ResponseBody List<ItemsReturnedData> fetchItemsReturned(){
        return service.getItemsReturned();
    }

    // FETCH BY ID
    @GetMapping("/items_returned/{id}")
    public ItemsReturnedData getItemReturnedById(@PathVariable Long id){
        return service.getItemsReturnedById(id);

    }

    // DELETE
    @DeleteMapping("/items_returned/{id}")
    public void deleteItem(@PathVariable Long id){
        service.deleteItemReturned(id);
    }

    // GET BY DATE RANGE
    @GetMapping("/items_returned/dateRange")
    public List<ItemsReturnedData> getItemsReturnedByDateRange(
            @RequestParam(value = "startDate") LocalDate startDate,
            @RequestParam(value = "endDate") LocalDate endDate

    ){
        return service.getItemsReturnedByDateRange(startDate, endDate);
    }

}
