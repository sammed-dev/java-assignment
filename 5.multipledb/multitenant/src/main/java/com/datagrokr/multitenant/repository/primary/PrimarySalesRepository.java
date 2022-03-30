package com.datagrokr.multitenant.repository.primary;

import com.datagrokr.multitenant.entity.primary.PrimarySales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimarySalesRepository extends JpaRepository<PrimarySales, Integer> {
    
}
