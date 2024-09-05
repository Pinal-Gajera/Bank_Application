package com.example.Bank.Service;

import com.example.Bank.model.bank;
import com.example.Bank.Repository.bankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class bankService {
    @Autowired
    bankRepository bankRepository;

    public void bankService(bank b) {
        UUID uuid=UUID.randomUUID();
        long num=Math.abs(uuid.toString().replace("-","").hashCode());
        Random random=new Random(10);
        while (String.valueOf(num).length()<10){
            num=num*10+random.nextInt();
        }
        if(String.valueOf(num).length()>10){
            System.out.println(Long.parseLong(String.valueOf(num).substring(10)));
            return;
        }
        b.setAccountNum(num);
        bankRepository.save(b);
    }

    public void diposite(long accountNum, int diposte) {
      bank b=bankRepository.findById(accountNum).get();
      int finalBalance=b.getBalance()+diposte;
      b.setBalance(finalBalance);
      bankRepository.save(b);
    }

    public String withdraw(long accountNum, int withdraw) {
        bank b=bankRepository.findById(accountNum).get();
        if(b.getBalance()>withdraw){
            int finalBalance=b.getBalance()-withdraw;
            b.setBalance(finalBalance);
            bankRepository.save(b);
            return "sucessesful";
        }
        return "insufficient balance";
    }

    public bank ShowBalance(long accountNum) {
      return bankRepository.findById(accountNum).get();
    }

    public String Transfermoney(long accountNum1, long accountNum2, int amount) {
        bank b1=bankRepository.findById(accountNum1).get();
        bank b2=bankRepository.findById(accountNum2).get();
        if(b1.getBalance()>amount){
            int finalBalance1=b1.getBalance()-amount;
            int finalBalance2=b2.getBalance()+ amount;
            b2.setBalance(finalBalance2);
            b1.setBalance(finalBalance1);
            bankRepository.save(b1);
            bankRepository.save(b2);
            return "sucessful";
        }
        return "can't Tranfer";
    }
}
