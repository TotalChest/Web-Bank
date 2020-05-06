package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class CustomerController {
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String Clients() {
        return "Customers";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String CurrentClient(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("id", id);
        return "CurrentCustomer";
    }

    @RequestMapping(value = "/add/customer", method = RequestMethod.GET)
    public String AddCustomer()
    {
        return  "AddCustomer";
    }

    @RequestMapping(value = "/change/customer", method = RequestMethod.GET)
    public String Change() {
        return "ChangeCustomer";
    }
}