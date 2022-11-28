package com.example.supermarketstore.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long>  {

    List<Store> findByDateProcuredBetween(LocalDate startDate, LocalDate endDate);

    List<Store> findByDateProcured(LocalDate dateProcured);





}
