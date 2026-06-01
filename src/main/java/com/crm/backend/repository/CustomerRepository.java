package com.crm.backend.repository;

import com.crm.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByCreatedBy(Long createdBy);
}
