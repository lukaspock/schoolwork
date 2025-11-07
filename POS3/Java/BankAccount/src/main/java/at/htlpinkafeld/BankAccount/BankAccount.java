package at.htlpinkafeld.BankAccount;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Objects;

public class BankAccount {

    private double[] transactionList;
    private int accountNumber;
    private String userName;

    public static void main(String[] args) {

    }

    public BankAccount() {
        this.transactionList = new double[0];
        this.accountNumber = 0;
        this.userName = null;
        //DEFAULT WITHOUT VALUES
    }

    public void  openAccount(int accountNumber, String userName) {
        this.accountNumber = accountNumber;
        this.userName = userName;
    }
    public void deposit(double amount) {
        double[] newList = new double[this.transactionList.length + 1];
        for(int i = 0; i < this.transactionList.length; i++){
            newList[i] = transactionList[i];
        }
        newList[this.transactionList.length] = amount;
        this.transactionList = newList;
    }

    public boolean withdraw(double amount) {

        if(this.calcBalance() < amount){
            System.out.println("ERROR - nicht genügend Geld am Konto");
            return false;
        }
        double[] newList = new double[this.transactionList.length + 1];

        if(amount > 0){
            amount = amount - 2 * amount;
        }

        for(int i = 0; i < this.transactionList.length; i++){
            newList[i] = transactionList[i];
        }
        newList[this.transactionList.length] = amount;
        this.transactionList = newList;
        return true;
    }

    double calcBalance() {
        double balance = 0;
        for(int i = 0; i < this.transactionList.length; i++){
            balance += this.transactionList[i];
        }
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "transactionList=" + Arrays.toString(transactionList) +
                ", accountNumber=" + accountNumber +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber && Objects.deepEquals(transactionList, that.transactionList) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(transactionList), accountNumber, userName);
    }
}


