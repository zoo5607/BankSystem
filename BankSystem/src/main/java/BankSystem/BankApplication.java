package BankSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.run();


    }
}