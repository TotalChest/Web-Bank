package spring;

import dao.*;
import forms.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String Customer(ModelMap map) {
        try {
            map.addAttribute("customersList", customerDAO.getAll());
            return "Customers";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String CurrentCustomer(@RequestParam(value="id", required=true) Long id, ModelMap map) {
        try {
            Customer c = customerDAO.getById(id);
            map.addAttribute("CustomerName", c.getName());
            map.addAttribute("CustomerDate", c.getDateOfRegistration());
            map.addAttribute("CustomerType", c.getType());
            return "CurrentCustomer";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/add/customer", method = RequestMethod.GET)
    public String addCustomerGet(ModelMap map) {
        try {
            map.addAttribute("customerForm", new CustomerForm());
            return "AddCustomer";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/add/customer", method = RequestMethod.POST)
    public String addCustomerPost(ModelMap map,
                                    @ModelAttribute("customerForm") CustomerForm customerForm) {
        try {
            saveCustomer(customerForm);
            return "redirect:Customers";
        } catch (Exception e) {
            return "Error";
        }
    }

    private void saveCustomer(CustomerForm customerForm) throws Exception {
        Customer customer = new Customer();
        Contact contact = new Contact();
        customer.setName(customerForm.getName());
        customer.setType(customerForm.getType());
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((new Date()).toString());
        customer.setDateOfRegistration(new Timestamp(date.getTime()));
        customerDAO.save(customer);

        contact.setAddress(customerForm.getAddress());
        contact.setSurname(customerForm.getSurname());
        contact.setName(customerForm.getName());
        contact.setCustomer(customer);
        contact.setEmail(customerForm.getEmail());
        contact.setPhoneNumber(customerForm.getPhoneNumber());
        contactDAO.save(contact);
    }

}