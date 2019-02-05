package main.model;

import javax.persistence.*;
import java.math.BigDecimal;

/*
Represents a class of type Account, which must belong to exactly one Client.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "account_Sequence")
    @SequenceGenerator(name = "account_Sequence", sequenceName = "ACCOUNT_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    //true = SAVINGS, false = CURRENT
    @Column(name = "type")
    private boolean type;

    @Column(name = "balance")
    private BigDecimal balance;

    //true = DR, false = CR
    @Column(name = "status")
    private boolean status;

    public Account(){

    }

    public Account(Client client, boolean type, BigDecimal balance, boolean status) {
        this.client = client;
        this.type = type;
        this.balance = balance;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
