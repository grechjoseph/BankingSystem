package main.service.impl;

import main.api.ApiAccount;
import main.exception.AccountNotFoundException;
import main.exception.ClientNotFoundException;
import main.mapping.ModelMapper;
import main.model.Account;
import main.model.Client;
import main.repository.AccountRepository;
import main.repository.ClientRepository;
import main.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ApiAccount addAccount(ApiAccount apiAccount, Long clientId){//??
        Client client = clientRepository.findOne(clientId);

        //Check if client exists with specified ID
        if(client == null) {
            throw new ClientNotFoundException(clientId);
        }

        Account account = modelMapper.map(apiAccount, Account.class);
        account.setClient(client);

        return modelMapper.map(accountRepository.save(account), ApiAccount.class);
    }

    public List<ApiAccount> getAccountByClientID(Long clientId){
        List<Account> accounts = accountRepository.findByClientId(clientId);

        return modelMapper.mapAsList(accounts, ApiAccount.class);
    }

    public ApiAccount getAccountByID(Long accountId){
        Account account = accountRepository.findOne(accountId);

        if(account == null)
            throw new AccountNotFoundException(accountId);

        return modelMapper.map(account, ApiAccount.class);
    }
}
