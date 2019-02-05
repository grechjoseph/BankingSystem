package main.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends IllegalArgumentException{
    public InsufficientFundsException(BigDecimal requested, BigDecimal available) {
        super("Insufficient funds available. Request: " + requested + ", Available: " + available + ".");
    }
}
