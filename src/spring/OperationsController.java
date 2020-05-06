package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class OperationsController {

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String Operations() {
        return "Operations";
    }
}