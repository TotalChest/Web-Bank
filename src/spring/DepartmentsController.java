package spring;

import dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import java.sql.SQLException;

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