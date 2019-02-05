package main.exception;

public class SelfTransferException extends IllegalArgumentException{
    public SelfTransferException() {
        super("Cannot transfer to same account.");
    }
}
