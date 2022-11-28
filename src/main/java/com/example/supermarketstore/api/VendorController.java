package com.example.supermarketstore.api;

import com.example.supermarketstore.domain.Vendor;
import com.example.supermarketstore.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class VendorController {

    private final VendorService service;

    // FETCH ALL
    @GetMapping("/vendor")
    public List<Vendor> getVendors(){
        return service.getVendors();
    }

    // FETCH BY ID
    @GetMapping("/vendor/{id}")
    public Vendor getVendorById (@PathVariable(value = "id") Long id){
        return service.getVendorById(id);
    }

    // POST
    @PostMapping("/vendor")
    public Vendor createVendor(@RequestBody Vendor data){
        return service.createVendor(data);
    }

    // UPDATE
    @PutMapping("/vendor/{id}")
    public @ResponseBody
    Vendor updateVendor(@PathVariable(name = "id") Long id,
                                          @RequestBody  Vendor data) {
       return service.updateVendor(data, id);
    }

    // DELETE
    @DeleteMapping("/vendor/{id}")
    public void deleteVendor(@PathVariable Long id){
        service.deleteVendor(id);
    }
}
