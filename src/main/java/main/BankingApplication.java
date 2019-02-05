package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {
    /*
    Initialize Spring Boot Application

    //1. Create a new client
    //2. List all clients
    //3. Get client details by ID
    //4. Create a new client account
    5. Effect a transfer between 2 accounts
    //6. List client accounts
    7. List account transactions
     */
    public static void main(String[] args){
        SpringApplication.run(BankingApplication.class, args);
    }
}
