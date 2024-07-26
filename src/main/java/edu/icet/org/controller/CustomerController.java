package edu.icet.org.controller;

import edu.icet.org.dto.Customer;
import edu.icet.org.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @PostMapping("/add")
    Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }
    @GetMapping("/get-all")
    List<Customer> getCustomers(){
        return service.getCustomers();
    }
    @PutMapping("/update")
    Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }
    @DeleteMapping("/{id}")
    Map<String, Boolean> removeById(@PathVariable Long id){
        return service.removeById(id);
    }

}
