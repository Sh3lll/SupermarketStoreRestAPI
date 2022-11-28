package com.example.supermarketstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "items_returned")
@Data

public class ItemsReturned {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_id_returned_fk"))
    private Store store;

    @OneToOne
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "vendor_id_returned_fk"))
    private Vendor vendor;

    @Column(name = "date_returned")
    private LocalDate dateReturned;

    @Column(name = "item_name")
    private String itemName;
}
