package spring;

import org.springframework.http.ResponseEntity;
import org.apache.openjpa.jdbc.sql.SQLExceptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class MainController {

    private final Application application;

    public MainController() {
        this.application = Application.getInstance();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root(ModelMap map){
        return "Root";
    }

    @RequestMapping(value = "/add/department", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity AddDepartment(
            @RequestParam("name") String name,
            @RequestParam("address") String address)
    {
        return  application.getInstance().addDepartment(name, address);
    }

    @RequestMapping(value = "/add/customer", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity AddCustomer(
            @RequestParam("type") String type,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phone") String phone,
            @RequestParam("mail") String mail,
            @RequestParam("address") String address)
    {
        return  application.getInstance().addCustomer(type, name, surname, address, phone, mail);
    }
}