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
}