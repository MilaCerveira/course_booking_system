package com.codeclan.example.coursebooking.components;

import com.codeclan.example.coursebooking.models.Booking;
import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.BookingRepository;
import com.codeclan.example.coursebooking.repositories.CourseRepository;
import com.codeclan.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("CodeClan", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("hot yoga", "Glasgow", 5);
        courseRepository.save(course2);

        Course course3 = new Course("how to get mega dollars", "Glasgow", 5);
        courseRepository.save(course3);

        Course course4 = new Course("Java for Dummies", "Glasgow", 4);
        courseRepository.save(course4);

        Customer customer1 = new Customer("Billy Bob", "Edinburgh", 24);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Bruce Springsteen", "Glasgow", 50);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Jack Brown", "Edinburgh", 60);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("27/03/2021", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("03/08/2021", course2, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("22/08/2021", course3, customer3);
        bookingRepository.save(booking3);

    }
}
