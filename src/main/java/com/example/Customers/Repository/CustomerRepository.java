package com.example.Customers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Customers.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
