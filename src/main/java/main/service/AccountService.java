package main.service;

import main.api.ApiAccount;

import java.util.List;

public interface AccountService {

    ApiAccount addAccount(ApiAccount apiAccount, Long clientId);

    List<ApiAccount> getAccountByClientID(Long clientId);

    ApiAccount getAccountByID(Long accountId);
}
