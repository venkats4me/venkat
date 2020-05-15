package com.springboot.learn.dao;

import com.springboot.learn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
}
