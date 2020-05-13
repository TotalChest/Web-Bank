package spring;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String Departments(ModelMap map) {
        try {
            map.addAttribute("competitionsList", departmentDAO.getAll());
            return "Departments";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/add/department", method = RequestMethod.GET)
    public String addCompetition(ModelMap map) {
        try {
            map.addAttribute("DepartmentForm", new DepartmentForm());
            return "AddDepartment";
        } catch (Exception e) {
            return "error";
        }
    }
}