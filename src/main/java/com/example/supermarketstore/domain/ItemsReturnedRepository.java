package com.example.supermarketstore.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ItemsReturnedRepository extends JpaRepository<ItemsReturned, Long> {
    List<ItemsReturned> findByDateReturnedBetween(LocalDate startDate, LocalDate endDate);
}
