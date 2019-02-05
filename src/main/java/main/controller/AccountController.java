package main.controller;

import main.api.ApiAccount;
import main.exception.AccountNotFoundException;
import main.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/clients/{clientId}/accounts")
    public List<ApiAccount> getAccountsByClientId(@PathVariable Long clientId){
        return accountService.getAccountByClientID(clientId);
    }

    @GetMapping("/accounts/{accountId}")
    public ApiAccount getAccountById(@PathVariable Long accountId) throws AccountNotFoundException
    {
        return accountService.getAccountByID(accountId);
    }
}
