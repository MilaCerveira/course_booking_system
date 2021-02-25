package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Get all customers for a given course

    // we want customers from a course

    // we have a course findByBookingsCustomerName

    List<Customer> findByBookingsCourseName(String name);
}
