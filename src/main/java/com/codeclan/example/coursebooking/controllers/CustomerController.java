package com.codeclan.example.coursebooking.controllers;

import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "age") Integer age
    ) { // if we have the course name then do the course query
        if (name != null) {
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(name), HttpStatus.OK);
        }
        // if we have the course town & the course name then do this
        if (town != null && courseName != null) {
            List<Customer> foundCustomer = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName);
            return new ResponseEntity(foundCustomer, HttpStatus.OK);
        }
        if (age > 20 && town != null) {
            List<Customer> foundCustomer = customerRepository.findByAgeAndTownAndBookingsCourseNameIgnoreCase(age, town, courseName);
            return new ResponseEntity(foundCustomer, HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
