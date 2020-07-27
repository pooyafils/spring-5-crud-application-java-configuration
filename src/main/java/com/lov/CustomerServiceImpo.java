package com.lov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpo implements CustomerService {
    //need to inject CustomerDao
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
    @Transactional
    @Override
    public void saveCustomer(Customer thecustomer) {
        customerDAO.saveCustomer(thecustomer);
    }
    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
}
