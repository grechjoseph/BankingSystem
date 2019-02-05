package main.api;

import java.math.BigDecimal;

public class ApiAccount {

    /* JSON
    {
        "clientId":1,
        "type":true,
        "balance":100.00,
        "status":true
        }
     */

    private Long id;
    private boolean type;
    private BigDecimal balance;
    private boolean status;

    public ApiAccount() {
    }

    public ApiAccount(Long id, boolean type, BigDecimal balance, boolean status) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
