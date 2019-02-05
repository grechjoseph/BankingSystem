package main.exception;

public class CountryBlankException extends IllegalArgumentException{
    public CountryBlankException() {
        super("The primary address's Country cannot be left blank.");
    }
}
