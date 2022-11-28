package com.example.supermarketstore.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendor")
@Data

public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vendor_name")
    private String vendorName;

}
