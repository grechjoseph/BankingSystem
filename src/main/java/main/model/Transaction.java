package main.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/*
Represents a class of type Transactions, which must belong to exactly one debtor and one creditor.
Debit account
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "transaction_Sequence")
    @SequenceGenerator(name = "transaction_Sequence", sequenceName = "TRANSACTION_SEQUENCE")
    private Long id;

    @OneToOne
    @JoinColumn(name = "debtor_id", nullable = false)
    private Account debtor;

    @OneToOne
    @JoinColumn(name = "creditor_id", nullable = false)
    private Account creditor;

    @Column(name = "debited_amount")
    private BigDecimal debitedAmount;

    @Column(name = "credited_amount")
    private BigDecimal creditedAmount;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Timestamp date;

    public Transaction(){

    }

    public Transaction(Account debtor, Account creditor, BigDecimal debitedAmount, BigDecimal creditedAmount, String message, Timestamp date) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.debitedAmount = debitedAmount;
        this.creditedAmount = creditedAmount;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getDebtor() {
        return debtor;
    }

    public void setDebtor(Account debtor) {
        this.debtor = debtor;
    }

    public Account getCreditor() {
        return creditor;
    }

    public void setCreditor(Account creditor) {
        this.creditor = creditor;
    }

    public BigDecimal getDebitedAmount() {
        return debitedAmount;
    }

    public void setDebitedAmount(BigDecimal debitedAmount) {
        this.debitedAmount = debitedAmount;
    }

    public BigDecimal getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(BigDecimal creditredAmount) {
        this.creditedAmount = creditredAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
