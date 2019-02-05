package main.service.impl;

import main.api.ApiTransaction;
import main.exception.AccountNotFoundException;
import main.exception.InsufficientFundsException;
import main.exception.SelfTransferException;
import main.mapping.ModelMapper;
import main.model.Account;
import main.model.Transaction;
import main.repository.AccountRepository;
import main.repository.TransactionRepository;
import main.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ApiTransaction makeTransaction(ApiTransaction apiTransaction, Long debtorId)
            throws AccountNotFoundException, InsufficientFundsException, SelfTransferException, InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println(
                Thread.currentThread().getName() + "::"
                        + new Timestamp(System.currentTimeMillis()).toString() + "::"
                        + "Make Transaction::Started...");

        //Check if transferring to same account
        if(debtorId.equals(apiTransaction.getCreditorId())) {
            throw new SelfTransferException();
        }

        System.out.println(
                Thread.currentThread().getName() + "::"
                        + new Timestamp(System.currentTimeMillis()).toString() + "::"
                        + "Make Transaction::Locking objects...");

        Account accountToDebit = accountRepository.findByIdAndLock(debtorId);
        Account accountToCredit = accountRepository.findByIdAndLock(apiTransaction.getCreditorId());

        System.out.println(
                Thread.currentThread().getName() + "::"
                        + new Timestamp(System.currentTimeMillis()).toString() + "::"
                        + "Make Transaction::Objects locked...");

        BigDecimal amount = apiTransaction.getDebitedAmount();

        if(accountToDebit == null) {
            throw new AccountNotFoundException(debtorId);
        }

        if(accountToCredit == null) {
            throw new AccountNotFoundException(apiTransaction.getCreditorId());
        }

        //true = DR, false = CR
        if(accountToDebit.isStatus()) {
            //Account is DR
            if (accountToDebit.getBalance().compareTo(amount) < 0) {
                //Account balance is < amount required
                throw new InsufficientFundsException(amount, accountToDebit.getBalance());
            }
        }

        //Deduct amount from debit account
        BigDecimal newDebitBalance;

        if(accountToDebit.isStatus()) {
            //Account is DR, so credit has to be added
            newDebitBalance = accountToDebit.getBalance().subtract(amount);
            accountToDebit.setBalance(newDebitBalance);
        }
        else {
            //Account is CR, so credit has to be subtracted from owed balance
            newDebitBalance = accountToDebit.getBalance().add(amount);
            accountToDebit.setBalance(newDebitBalance);
        }

        //Add amount to debit account
        BigDecimal newCreditBalance;
        if(accountToCredit.isStatus()) {
            //Account is DR, so credit has to be added
            newCreditBalance = accountToCredit.getBalance().add(amount);
            accountToCredit.setBalance(newCreditBalance);
        }
        else {
            //Account is CR, so credit has to be subtracted from owed balance
            newCreditBalance = accountToCredit.getBalance().subtract(amount);
            accountToCredit.setBalance(newCreditBalance);
        }

        //Update accounts with new balances
        accountRepository.save(accountToDebit);
        accountRepository.save(accountToCredit);

        Transaction transaction = new Transaction(
                accountToDebit, accountToCredit, amount, amount, apiTransaction.getMessage(), new Timestamp(System.currentTimeMillis())
        );

        //Save transaction in db
        transactionRepository.save(transaction);

        System.out.println(
                Thread.currentThread().getName() + "::"
                        + new Timestamp(System.currentTimeMillis()).toString() + "::"
                + "Make Transaction::Transaction complete");

        return modelMapper.map(transaction, ApiTransaction.class);
    }

    public List<ApiTransaction> getTransactionsByAccountId(Long accountId)
            throws AccountNotFoundException{
        if(accountRepository.findOne(accountId) == null) {
            throw new AccountNotFoundException(accountId);
        }

        List<Transaction> transactions = transactionRepository.findByCreditorIdOrDebtorId(accountId, accountId);

        return modelMapper.mapAsList(transactions, ApiTransaction.class);
    }
}
