package com.springboot.learn.sevices;

import com.springboot.learn.dao.CustomerDAO;
import com.springboot.learn.exception.CustomerNotFoundException;
import com.springboot.learn.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId)  {
        /*return customerDAO.findAll()
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> customerOpt =customerDAO.findById(customerId);
         if(!customerOpt.isPresent()){
             throw new CustomerNotFoundException("Cusomer record not found");
         }
        return customerOpt.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        /*customerList
                .stream().forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                }

        );
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
        /*customerList.stream().forEach(c -> {
            if (c.getCustomerId() == customerId) {
                customerList.remove(c);
            }
        });*/
        customerDAO.deleteById(customerId);
    }
}
