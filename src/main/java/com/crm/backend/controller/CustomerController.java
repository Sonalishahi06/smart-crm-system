package com.crm.backend.controller;

import com.crm.backend.entity.Customer;
import com.crm.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public Page<Customer> getAllCustomers(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size
    ){
        return customerService.getAllCustomers(page, size);
    }

    @GetMapping("/search")
    public List<Customer> searchCustomers(@RequestParam String name){
        return customerService.searchCustomers(name);
    }

    @GetMapping("/filter")
    public List<Customer> filterCustomersByStatus(@RequestParam Customer.Status status){
        return customerService.filterCustomerByStatus(status);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer
    ){
        return customerService.updateCustomer(id, customer);
    }
}
