package main.exception;

public class AccountNotFoundException extends IllegalArgumentException {
    public AccountNotFoundException(Long clientId) {
        super("Account with id " + clientId + " not found");
    }
}
