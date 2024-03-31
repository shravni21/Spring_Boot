package com.example.demo.rest;

import com.example.demo.entity.Customer;
import com.example.demo.service.service_interface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
//        customer.setId(0);
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null) {
            throw new RuntimeException("Customer not found with id: " + id);
        }

        // Update the existing customer object with the new values
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setContactNumber(customer.getContactNumber());
        existingCustomer.setBroadbandConnection(customer.getBroadbandConnection());

        // Save the updated customer object
        return customerService.saveCustomer(existingCustomer);
    }


    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        customerService.deleteCustomer(id);
        return "Deleted customer with id: " + id;
    }
}

