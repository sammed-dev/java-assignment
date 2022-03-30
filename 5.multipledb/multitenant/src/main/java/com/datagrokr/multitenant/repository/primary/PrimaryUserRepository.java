package com.datagrokr.multitenant.repository.primary;

import com.datagrokr.multitenant.entity.primary.PrimaryUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Integer> {
    
}
