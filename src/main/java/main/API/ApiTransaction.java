package main.api;

import java.math.BigDecimal;

public class ApiTransaction {

    /* JSON
    {
    "debtorId":null,
    "creditorId":2,
    "debitedAmount":10,
    "creditedAmount":null,
    "message":"Hello World!"
    }
     */

    private Long debtorId;
    private Long creditorId;
    private BigDecimal debitedAmount;
    private BigDecimal creditedAmount;
    private String message;

    public ApiTransaction() {
    }

    public ApiTransaction(Long debtorId, Long creditorId, BigDecimal debitedAmount, BigDecimal creditedAmount, String message) {
        this.debtorId = debtorId;
        this.creditorId = creditorId;
        this.debitedAmount = debitedAmount;
        this.creditedAmount = creditedAmount;
        this.message = message;
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
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

    public void setCreditedAmount(BigDecimal creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
