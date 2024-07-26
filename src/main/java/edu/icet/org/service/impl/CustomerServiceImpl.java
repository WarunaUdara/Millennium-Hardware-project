package edu.icet.org.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.org.dto.Customer;
import edu.icet.org.entity.CustomerEntity;
import edu.icet.org.repository.CustomerJpaRepository;
import edu.icet.org.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerJpaRepository jpaRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        ObjectMapper mapper=new ObjectMapper();
        CustomerEntity customerEntity = mapper.convertValue(customer, CustomerEntity.class);
        CustomerEntity saved = jpaRepository.save(customerEntity);
        return mapper.convertValue(saved,Customer.class);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList=new ArrayList<>();
        ObjectMapper mapper=new ObjectMapper();
        for (CustomerEntity customerEntity : jpaRepository.findAll()) {
            customerList.add(mapper.convertValue(customerEntity,Customer.class));
        }
        return customerList;
    }
    @Override
    public Customer update(Customer customer) {
        if(jpaRepository.existsById(customer.getId())){
            ObjectMapper mapper=new ObjectMapper();
            return mapper.convertValue(jpaRepository.save(
                    mapper.convertValue(customer, CustomerEntity.class)),Customer.class);
        }
        return null;
    }

    @Override
    public Map<String, Boolean> removeById(Long id) {
        if(jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id);
            return Collections.singletonMap("isDeletedSuccessful",true);

        }
        return Collections.singletonMap("isDeletedSuccessful",false);

    }
}
