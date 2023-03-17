package co.istad.banking;

import co.istad.banking.database.Database;

import java.security.PublicKey;

public class SavingAccount extends Account{
   private Double interest;
   private  Interest interestI;

       public SavingAccount (){
           setInterestI(new Interest() {
               @Override
               public Double calculate(Double amount) {
                   return amount * 0.01;
               }
           });
       }

   public SavingAccount(Integer number, String name, Double balance) {
           super(number, name, balance);
       }


   class  DefaultInterest implements Interest{

       @Override
       public Double calculate(Double amount) {
           return amount*0.06;
       }
   }
    public Interest getInterestI() {
        return interestI;
    }

    public void setInterestI(Interest interestI) {
        this.interestI = interestI;
    }

    public Double getInterest() {
        return interest;
    }

    public  void calculateInterest(){
       interest= interestI.calculate(getBalance());
    }
public void Calculate(){

}

    @Override
    protected void showBalance() {
        System.out.println();
        System.out.println("||||||||||||||||||||||||||<-- Saving Account Information -->||||||||||||||||");
        System.out.println("Saving Account Number :" +getNumber());
        System.out.println("Saving Account Name :"+ getName());
        System.out.println("Account Balance $:" +getBalance());
    }
}
