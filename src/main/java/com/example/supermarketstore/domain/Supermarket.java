package com.example.supermarketstore.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "supermarket")
@Data

public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "date_received")
    private LocalDate dateReceived;

    @Column(name = "price")
    private Double price;

}
