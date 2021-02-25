package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Get all courses with a given rating
    List<Course> findByRating(int rating);

    // Get all courses for a given customer
     List<Course> findByBookingsCustomerName(String name);
}
