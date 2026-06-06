package com.crm.backend.service;

import com.crm.backend.entity.Customer;
import com.crm.backend.entity.User;
import com.crm.backend.repository.CustomerRepository;
import com.crm.backend.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationNotSupportedException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    public Customer createCustomer(Customer customer){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        User user=userRepository.findByEmail(email);
        customer.setCreatedBy(user.getId());
        return customerRepository.save(customer);
    }


    public Page<Customer> getAllCustomers(int page, int size){
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        String email = auth.getName();

        User user = userRepository.findByEmail(email);
        Pageable pageable= PageRequest.of(page, size);
        if("ADMIN".equals(user.getRole())){
            return customerRepository.findAll(pageable);
        }
        return customerRepository.findByCreatedBy(user.getId(),pageable);
    }

    public List<Customer> searchCustomers(String name){
        Authentication auth=
                SecurityContextHolder.getContext().getAuthentication();

        String email=auth.getName();
        User user=userRepository.findByEmail(email);
        if("ADMIN".equals((user.getRole()))){
            return customerRepository.findByNameContainingIgnoreCase(name);
        }
        return customerRepository.findByNameContainingIgnoreCase(name).
                stream()
                .filter(customer -> customer.getCreatedBy().equals(user.getId()))
                .toList();
    }

    public List<Customer> filterCustomerByStatus(Customer.Status status){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        String email= auth.getName();
        User user =userRepository.findByEmail(email);
        if("ADMIN".equals(user.getRole())){
            return customerRepository.findByStatus(status);
        }
        return customerRepository.findByCreatedByAndStatus(user.getId(),status);
    }


    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer){

        Customer customer = customerRepository.findById(id).orElse(null);

        if(customer != null){

            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setCompany(updatedCustomer.getCompany());
            customer.setStatus(updatedCustomer.getStatus());

            return customerRepository.save(customer);
        }

        return null;
    }
}
