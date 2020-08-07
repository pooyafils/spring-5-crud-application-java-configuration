package com.lov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
    public class CustomerDAOImpl implements CustomerDAO {
        //wey we dont have @transactional
        // need to inject the session factory
        @Autowired
        private SessionFactory sessionFactory;

        @Override
       // @Transactional
        //we comment it when we have a service
        public List<Customer> getCustomers() {

// get the current hibernate session
            Session currentSession = sessionFactory.getCurrentSession();

// create a query
            Query<Customer> theQuery =
                    currentSession.createQuery("from Customer order by lastName", Customer.class);

// execute query and get result list
            List<Customer> customers = theQuery.getResultList();

// return the results
            return customers;
        }

    @Override
    public void saveCustomer(Customer thecustomer) {
        //get cureent hibernate session
        Session currentsession=sessionFactory.getCurrentSession();
        currentsession.saveOrUpdate(thecustomer);

        //save customer
    }


    @Override
    public Customer getCustomer(int id) {
        //get currnt hibernate session
        Session currentsessiontwo=sessionFactory.getCurrentSession();
        //retrieve/read from database using the primary key
        Customer thecustomer=currentsessiontwo.get(Customer.class,id);

        return thecustomer;
    }

    @Override
    public void deleting(Customer mycustomer) {
        Session currentsession=sessionFactory.getCurrentSession();
        currentsession.delete(mycustomer);

    }
}

