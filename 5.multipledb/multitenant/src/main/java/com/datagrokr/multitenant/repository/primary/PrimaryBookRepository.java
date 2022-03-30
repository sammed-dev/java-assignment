package com.datagrokr.multitenant.repository.primary;

import com.datagrokr.multitenant.entity.primary.PrimaryBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryBookRepository extends JpaRepository<PrimaryBook, Integer> {
    
}
