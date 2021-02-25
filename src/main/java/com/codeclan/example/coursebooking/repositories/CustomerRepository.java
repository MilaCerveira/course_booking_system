package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
        //Get all customers over a certain age in a given town for a given course

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);
    List<Customer> findByAgeAndTownAndBookingsCourseNameIgnoreCase(Integer age, String town, String courseName);
}
