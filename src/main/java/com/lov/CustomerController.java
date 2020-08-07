package com.lov;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lov.CustomerDAO;
import com.lov.Customer;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/c")
public class CustomerController {

    // need to inject the customer dao
   // @Autowired
   // private CustomerDAO customerDAO;
// i comment it because now i have a service layer

    //injecting customer service
    @Autowired
    private CustomerService customerService;
@RequestMapping("/")
  public  String home(){
      return "home";
  }

    @RequestMapping("/customer/list")
   // @GetMapping("/list")
    public String listCustomers(Model theModel) {

// get customers from the dao
      //  List<Customer> theCustomers = customerDAO.getCustomers(); we have service layer
        List<Customer> theCustomers=customerService.getCustomers();
// add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }


    @GetMapping("/customer/showFormForAdd")
    public String showFormForAdd(Model themodel){
        Customer thecustomer=new Customer();
        themodel.addAttribute("customer",thecustomer);
        return "customer-form";
    }
    @RequestMapping(value = "/customer/savecustomer",method = POST)
    public String saveCustomer(@ModelAttribute("customer") Customer thecustomer){
        customerService.saveCustomer(thecustomer);
        return "redirect:/c/customer/list";
    }
    @GetMapping("/customer/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerid") int Id,Model model){
        //get customer from our service
        Customer thecustomer=customerService.getCustomer(Id);
        //set customer as a model atrbuite
        model.addAttribute("customer",thecustomer);
        // send ot over for form

        return"customer-form";
    }
    @RequestMapping("/customer/delete")
    public String deletingCustomer(@RequestParam("customerid") int Id,Model model){
        Customer mycustomer=customerService.getCustomer(Id);
        customerService.deleting(mycustomer);
        return "redirect:/c/customer/list";
    }
}

