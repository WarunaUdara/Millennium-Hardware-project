package edu.icet.org.service;

import edu.icet.org.dto.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer update(Customer customer);

    Map<String, Boolean> removeById(Long id);
}
