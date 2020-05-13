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
public class OperationsController {

    @Autowired
    private OperationsDAO operationsDAO;

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
        public String getCompetitions(ModelMap map) {
            try {
                map.addAttribute("competitionsList", operationsDAO.getAll());
                return "Operations";
            } catch (Exception e) {
                return "Error";
            }
        }
}