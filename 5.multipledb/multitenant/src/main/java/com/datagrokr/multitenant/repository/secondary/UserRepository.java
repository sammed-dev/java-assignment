package com.datagrokr.multitenant.repository.secondary;

import com.datagrokr.multitenant.entity.secondary.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
