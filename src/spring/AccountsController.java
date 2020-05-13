package spring;

import dao.*;
import forms.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class AccountsController {

    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String Accounts(ModelMap map) {
        try {
            map.addAttribute("accountsList", accountDAO.getAll());
            return "Accounts";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String CurrentAccount(@RequestParam(value="id", required=true) Long id, ModelMap map) {
        try {
            Account a = accountDAO.getById(id);
            map.addAttribute("AccountCustomer", a.getCustomer());
            map.addAttribute("AccountNumber", a.getNumber());
            map.addAttribute("AccountBalance", a.getBalance());
            map.addAttribute("AccountType", a.getType());
            map.addAttribute("AccountInterest", a.getInterestAccount());
            map.addAttribute("AccountDepartment", a.getDepartment());
            map.addAttribute("AccountDate", a.getDate());
            return "CurrentAccount";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.GET)
    public String addAccountGet(ModelMap map) {
        try {
            map.addAttribute("accountForm", new AccountForm());
            return "AddAccount";
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(value = "/add/account", method = RequestMethod.POST)
    public String addAccountPost(ModelMap map,
                                  @ModelAttribute("accountForm") AccountForm accountForm) {
        try {
            saveAccount(accountForm);
            return "redirect:Accounts";
        } catch (Exception e) {
            return "Error";
        }
    }

    private void saveAccount(AccountForm accountForm) throws Exception {
        Account account = new Account();
        account.setCustomer(accountForm.getCustomer());
        account.setNumber(accountForm.getNumber());
        account.setBalance((float)0.0);
        account.setType(accountForm.getType());
        account.setInterestAccount(accountForm.getInterestAccount());
        account.setDepartment(accountForm.getDepartment());
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((new Date()).toString());
        account.setDate(new Timestamp(date.getTime()));
        accountDAO.save(account);
    }

}