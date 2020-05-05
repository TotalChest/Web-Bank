package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root() {
        return "Root";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String Clients() {
        return "Clients";
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String Accounts() {
        return "Accounts";
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String Departments() {
        return "Departments";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String Operations() {
        return "Operations";
    }

    @RequestMapping(value = "/add/{entity}", method = RequestMethod.GET)
    public String Add(@PathVariable(value = "entity") String entity) {
        String capitalized = entity.substring(0, 1).toUpperCase() + entity.substring(1);
        return "Add" + capitalized;
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String CurrentAccount(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("id", id);
        return "CurrentAccount";
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public String CurrentClient(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("id", id);
        return "CurrentClient";
    }

    @RequestMapping(value = "/change/client", method = RequestMethod.GET)
    public String Change() {
        return "ChangeClient";
    }
}