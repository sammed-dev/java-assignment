package com.datagrokr.multitenant.repository.secondary;

import com.datagrokr.multitenant.entity.secondary.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
