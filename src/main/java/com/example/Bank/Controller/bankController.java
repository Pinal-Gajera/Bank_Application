package com.example.Bank.Controller;

import com.example.Bank.model.bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Bank.Service.bankService;

@RestController
@RequestMapping("bank")
public class bankController {
    @Autowired
    bankService bankService;

    @PostMapping("OpenAccount")
    public void OpenAccount(@RequestBody bank b){
        bankService.bankService(b);
    }

   @PutMapping("diposite/{AccountNum}/{diposite}")
   public void Diposite(@PathVariable(value ="AccountNum")long AccountNum,@PathVariable(value = "diposite")int diposte){
        bankService.diposite(AccountNum,diposte);
   }

   @PutMapping("withdraw/{AccountNum}/{withdraw}")
    public String Withdraw(@PathVariable(value = "AccountNum")long AccountNum,@PathVariable(value = "withdraw")int withdraw){
        return bankService.withdraw(AccountNum,withdraw);
   }

   @GetMapping("showbalance/{AccountNum}")
    public bank ShowBalance(@PathVariable(value = "AccountNum")long AccountNum){
        return bankService.ShowBalance(AccountNum);
   }

   @PutMapping("transfermoney/{AccountNum1}/{AccountNum2}/{amount}")
    public String Transfermoney(@PathVariable(value = "AccountNum1")long AccountNum1,@PathVariable(value = "AccountNum2")long AccountNum2,@PathVariable(value = "amount")int amount){
        return bankService.Transfermoney(AccountNum1,AccountNum2,amount);
   }

}
