package com.example.supermarketstore.domain;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "date_procured")
    private LocalDate dateProcured;

    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn( name = "vendor_id", foreignKey = @ForeignKey(name = "vendor_id_store_fk"))
    private Vendor vendor;




}
