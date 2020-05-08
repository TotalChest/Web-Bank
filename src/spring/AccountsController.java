package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class AccountsController {
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String Accounts() {
        return "Accounts";
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.GET)
    public String AddAccount()
    {
        return  "AddAccount";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String CurrentAccount(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("id", id);
        return "CurrentAccount";
    }
}