package co.istad.banking;

import co.istad.banking.database.Database;

import java.time.LocalDate;

public class BankingProgram {
    public static  void main (String[] args){
        CreditCard creditCard = new CreditCard();
        creditCard.setPin(1234);
        creditCard.setNumber(33334444);

        //Check credit card Exist or not

        if(Database.creditCard().getNumber().equals(creditCard.getNumber())){
            creditCard= Database.creditCard();
        }else{
            System.out.println("Invalid ");
            return;
        }
        creditCard.withdrawal(500.0);
        creditCard.deposite(1500.0);
        creditCard.showBalance();

        SavingAccount savingAccount= new SavingAccount(33334444,"Thy",3000.0);
        savingAccount.showBalance();
        SavingAccount mySaving = Database.saving();
        mySaving.setInterestI(new RielRate());
        mySaving.calculateInterest();
        System.out.println("Interest : "+ mySaving.getInterest());
        System.out.println("|||||||||||||||||||||||||||||||||||||--Rial--|||||||||||||||||||||||||||||||||||||||");


        

    }

}
