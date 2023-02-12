package de.niklas.classes;

public class Account {
    private int accountNumber;
    private String accountOwner;
    private int accountHeight;
    private int accountLimit;

    public Account(int accountNumber, String accountOwner, int accountHeight, int accountLimit) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountHeight = accountHeight;
        this.accountLimit = accountLimit;
    }

    public int getAccountHeight() {
        return this.accountHeight;
    }

    @Override
    public String toString() {
        return  "Konto Nr. " + this.accountNumber + " (" + this.accountOwner + "), " +
                "Stand: " + this.accountHeight + " ct " +
                "Limit " + this.accountLimit + " ct";
    }

    public void processDeposit(int amount){
        this.accountHeight += amount;
    }

    public void processPayment(int amount){
        if(this.accountHeight - amount >= (this.accountLimit*-1)){
            this.accountHeight -= amount;
        }
        else{
            System.out.println("\u001B[31mDeckung nicht ausreichend!\u001B[0m");
        }
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }

}
