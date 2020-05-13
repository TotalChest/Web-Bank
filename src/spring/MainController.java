package spring;

import org.springframework.http.ResponseEntity;
//import org.apache.openjpa.jdbc.sql.SQLExceptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root(ModelMap map){
        return "Root";
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String Error(ModelMap map){
        return "Error";
    }

}