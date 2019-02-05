package main.exception;

public class ClientNotFoundException extends IllegalArgumentException {

    public ClientNotFoundException(Long clientId) {
        super("Client with id " + clientId + " not found");
    }
}
