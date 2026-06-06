package com.crm.backend.repository;

import com.crm.backend.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findByCreatedBy(Long createdBy, Pageable pageable);
    List<Customer> findByNameContainingIgnoreCase(String name);
    List<Customer> findByStatus(Customer.Status status);
    List<Customer> findByCreatedByAndStatus(Long createdBy,Customer.Status status);
}
