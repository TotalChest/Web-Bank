package spring;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
public class DepartmentsController {
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String Departments() {
        return "Departments";
    }

    @RequestMapping(value = "/add/department", method = RequestMethod.GET)
    public String AddDepartment()
    {
        return  "AddDepartment";
    }
}