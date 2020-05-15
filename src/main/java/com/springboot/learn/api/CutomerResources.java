package com.springboot.learn.api;

import com.springboot.learn.model.Customer;
import com.springboot.learn.sevices.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CutomerResources {
    @Autowired
    private CustomerService  customerService;
     @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer){
    return customerService.addCustomer(customer);
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
      return customerService.getCustomers();
    }
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerService.getCustomer(customerId);
    }
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerid,@RequestBody Customer customer){
         return customerService.updateCustomer(customerid,customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int cid){
         customerService.deleteCustomer(cid);
         return new ResponseEntity<String>("customer deleted with id="+cid,HttpStatus.OK);
    }








}
