package co.istad.banking;

import co.istad.banking.database.Database;

public abstract class Account {
    private Integer number;
    private String name;
    private Double balance;

    public Account(){
        //Default
    }
    public Account(Integer number, String name, Double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance= balance;
    }

    protected void deposite(Double amount){
        if (amount<0){
            System.out.println("Are You kidding me?");
            return;
        }

        if (amount==0){
            System.out.println("You cannot deposit");
            return;
        }
        balance+=amount;
    }

    protected  void withdrawal(Double amount){
        if (amount<0)
        {
            System.out.println("Are you kidding me ?");
            return;
        }
        if (amount>balance){
            System.out.println("Invalid balance");
            return;
        }
        balance-=amount;
    }

    protected abstract void showBalance();


}
