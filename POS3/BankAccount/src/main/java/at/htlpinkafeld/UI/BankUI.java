package at.htlpinkafeld.UI;

import java.util.Scanner;


import at.htlpinkafeld.BankAccount.BankAccount;

public class BankUI {

    private BankAccount[]  bankAccounts =  new BankAccount[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankUI bankUI = new BankUI();
        int abfrage = 1;
        int idx = 0;

        System.out.println("How Many Accounts do you want to create? ");
        int amount = sc.nextInt();

        bankUI.initAccounts(amount);

        while(abfrage == 1){

            System.out.println("What do you want to do?");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Print");
            idx = sc.nextInt();

            switch(idx){
                case 1: bankUI.withdrawMenu(amount);
                        break;
                case 2: bankUI.depositMenu(amount);
                        break;
                case 3: bankUI.printAccounts(amount);
                        break;
            }

            System.out.println(" ");

            System.out.println("Wollen sie das Programm nochmal durchführen? (ja = 1)");
            abfrage = sc.nextInt();
        }
        System.out.println("Programm beendet!");
        System.out.println("Ausgabe aller Accounts:");
        bankUI.printAccounts(amount);
    }

    public BankUI() {
        for(int i = 0; i < 100; i++){
            this.bankAccounts[i] = new BankAccount();
        }
    }

    public void initAccounts(int amount){
        Scanner sc = new Scanner(System.in);
        int accountNumber;
        String name;
        for(int i = 0; i < amount; i++){
            System.out.println( i+1 + ". Account");
            System.out.println("Enter Account Number: ");
            accountNumber = sc.nextInt();
            System.out.println("Enter Account Name: ");
            name = sc.next();

            this.bankAccounts[i].openAccount(accountNumber,name);
        }

    }

    public void withdrawMenu(int noe){
        Scanner sc = new Scanner(System.in);
        int abfrage = 1;
        int idx = 0;
        int amount = 0;

        while(abfrage == 1){
            System.out.println("Von welchem Account wollen sie abheben?");
            idx = sc.nextInt() - 1;

            if(idx > noe){
                System.out.println("ERROR - typed index is greater than noe");
            }
            else {

                System.out.println("Wie viel Geld wollen sie abheben?");
                amount = sc.nextInt();

                this.bankAccounts[idx].withdraw(amount);
            }

            System.out.println("Wollen sie Mehr abheben? (ja = 1)");
            abfrage = sc.nextInt();
        }
    }
    public void depositMenu(int noe){
        Scanner sc = new Scanner(System.in);
        int abfrage = 1;
        int idx = 0;
        int amount = 0;

        while(abfrage == 1){
            System.out.println("Auf welchen Account wollen sie einzahlen?");
            idx = sc.nextInt() - 1;

            if(idx > noe){
                System.out.println("ERROR - typed index is greater than noe");
            }
            else{
                System.out.println("Wie viel Geld wollen sie einzahlen?");
                amount = sc.nextInt();

                this.bankAccounts[idx].deposit(amount);
            }


            System.out.println("Wollen sie weiter einzahlen? (ja = 1)");
            abfrage = sc.nextInt();
        }
    }
    public void printAccounts(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(this.bankAccounts[i].toString());
        }
    }

}
