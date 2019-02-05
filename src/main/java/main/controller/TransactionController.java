package main.controller;

import main.api.ApiAccount;
import main.api.ApiTransaction;
import main.service.AccountService;
import main.service.TransactionService;
import main.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @PostMapping("/accounts/{debtorId}/transactions")
    public ApiTransaction makeTransaction(@RequestBody ApiTransaction apiTransaction, @PathVariable Long debtorId) throws InterruptedException {
        return transactionService.makeTransaction(apiTransaction, debtorId);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public List<ApiTransaction> getTransactionsByAccountId(@PathVariable Long accountId){
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @GetMapping("/accounts/test")
    public String testMakeTransaction(){
        BigDecimal balance = accountService.getAccountByID(1l).getBalance();

        System.out.println("Initial Balance::" + balance);

        Thread thread1 = new Thread(){
            public void run(){
                ApiTransaction apiTransaction = new ApiTransaction(
                        null, 2l, new BigDecimal(10), null, "Hello World!");
                try {
                    makeTransaction(apiTransaction, 1l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                BigDecimal balance = accountService.getAccountByID(1l).getBalance();

                System.out.println("Balance after 1::" + balance);
            }
        };

        Thread thread2 = new Thread(){
            public void run(){
                ApiTransaction apiTransaction = new ApiTransaction(
                        null, 2l, new BigDecimal(10), null, "Hello World!");
                try {
                    makeTransaction(apiTransaction, 1l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                BigDecimal balance = accountService.getAccountByID(1l).getBalance();

                System.out.println("Balance after 2::" + balance);
            }
        };

        Thread thread3 = new Thread(){
            public void run(){
                ApiTransaction apiTransaction = new ApiTransaction(
                        null, 2l, new BigDecimal(10), null, "Hello World!");
                try {
                    makeTransaction(apiTransaction, 1l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                BigDecimal balance = accountService.getAccountByID(1l).getBalance();

                System.out.println("Balance after 3::" + balance);
            }
        };

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        balance = accountService.getAccountByID(1l).getBalance();

        System.out.println("Final Balance::" + balance);

        return "";
    }
}
