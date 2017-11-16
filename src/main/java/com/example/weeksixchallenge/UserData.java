package com.example.weeksixchallenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserData {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
    private String acctNumber;
    
    @NotNull
    private String action; //will be asked withdraw or deposit
    
    @NotNull
    private double amount;
    
    private String reason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber=acctNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action=action;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount=amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason=reason;
    }
}
