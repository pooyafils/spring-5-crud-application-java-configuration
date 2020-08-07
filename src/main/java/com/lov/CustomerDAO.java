package com.lov;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

   public void saveCustomer(Customer thecustomer);

    Customer getCustomer(int id);

    void deleting(Customer mycustomer);
}
