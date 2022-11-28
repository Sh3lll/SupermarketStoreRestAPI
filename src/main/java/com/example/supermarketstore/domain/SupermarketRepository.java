package com.example.supermarketstore.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {
    List<Supermarket> findByDateReceived(LocalDate dateProcured);
}
