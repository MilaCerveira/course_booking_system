package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
        //Get all customers over a certain age in a given town for a given course

    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);
    List<Customer> findByAgeAndTownAndBookingsCourseName(Integer age, String town, String courseName);
}
