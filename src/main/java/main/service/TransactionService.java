package main.service;

import main.api.ApiTransaction;

import java.util.List;

public interface TransactionService {

    ApiTransaction makeTransaction(ApiTransaction apiTransaction, Long debtorId) throws InterruptedException;

    List<ApiTransaction> getTransactionsByAccountId(Long accountId);
}
