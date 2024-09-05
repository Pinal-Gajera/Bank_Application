package com.example.Bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Json
//  {
//     "name":"ABC",
//        "balance":10000
//
//   }


@Entity
@Table(name="Bank")
public class bank {
    @Id
    @Column(name = "AccountNum")
    private long AccountNum;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private int balance;

    public long getAccountNum() {
        return AccountNum;
    }

    public  void setAccountNum(long accountNum) {
        AccountNum = accountNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
