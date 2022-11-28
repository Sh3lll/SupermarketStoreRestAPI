package com.example.supermarketstore.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VendorData {

    @JsonProperty("vendorName")
    private String vendorName;
}
