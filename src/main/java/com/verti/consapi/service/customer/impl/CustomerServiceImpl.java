package com.verti.consapi.service.customer.impl;

import com.verti.consapi.model.Customer;
import com.verti.consapi.repository.customer.CustomerRepository;
import com.verti.consapi.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public Customer getCustomerByEmail(final String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    @Transactional
    public void saveCustomer(final Customer customer) {
        customerRepository.save(customer);
    }

}
