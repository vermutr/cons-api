package com.verti.consapi.service.customer;

import com.verti.consapi.model.Customer;

public interface CustomerService {

    Customer getCustomerByEmail(final String email);

    void saveCustomer(final Customer customer);

}
