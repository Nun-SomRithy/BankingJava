package co.istad.banking;

import co.istad.banking.database.Database;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CreditCard  extends  Account{
    private Integer pin;
     private Double limitAmount; //limit 1000
     private LocalDate thruDate; //expired

    public  CreditCard(){

    }
    public CreditCard(Integer number, String name, Double balance) {
        super(number, name, balance);
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    @Override
    protected void deposite(Double amount) {
        //what day is today
        isExpired(thruDate);
        if (isExpired(thruDate)){
            System.out.println("Card is expired !!");
                    return;
        }
        super.deposite(amount);
    }

    @Override
    protected void withdrawal(Double amount) {


        if (amount>limitAmount){
            System.out.println("Over the Limit Amount ...!");
            return;
        }

        if (isExpired(thruDate)){
            System.out.println("Your Card is Expired ....!");
            return;
        }

        super.withdrawal(amount);
    }

    @Override
    protected void showBalance() {
        System.out.println("");
        System.out.println("---------------------------------Account Information---------------------");
        System.out.println("Account Number :" +getNumber());
        System.out.println("Account Name :"+ getName());
        System.out.println("Account Balance $:" +getBalance());
        System.out.println("Pin :" +pin);
        System.out.println("Thru Date :" +thruDate);
        System.out.println("Limit Balance $:" +limitAmount);
        System.out.println("--------------------------------------------------------------------------");
    }
    private boolean isExpired(LocalDate date){
    LocalDate now= LocalDate.now();
        return now.isAfter(date);
    }
}
