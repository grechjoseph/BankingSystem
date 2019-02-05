package main.controller;

import main.api.ApiAccount;
import main.api.ApiClient;
import main.exception.ClientNotFoundException;
import main.exception.CountryBlankException;
import main.service.AccountService;
import main.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @PostMapping("/clients")
    public ApiClient addClient(@RequestBody ApiClient apiClient) throws CountryBlankException //todo
    {
        return clientService.addClient(apiClient);
    }

    @GetMapping("/clients")
    public List<ApiClient> getAllClients() {
        return clientService.getAllClients(); //todo
    }

    @GetMapping("/clients/{clientId}")
    public ApiClient getClientById(@PathVariable Long clientId) throws ClientNotFoundException { //todo
        return clientService.getClientByID(clientId);
    }

    @PostMapping("/clients/{clientId}/accounts")
    public ApiAccount addAccountForClient(@PathVariable Long clientId, @RequestBody ApiAccount apiAccount){

        return accountService.addAccount(apiAccount, clientId);
    }
}
