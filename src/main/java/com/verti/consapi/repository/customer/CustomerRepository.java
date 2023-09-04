package com.verti.consapi.repository.customer;

import com.verti.consapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findCustomerByEmail(final String email);

}
