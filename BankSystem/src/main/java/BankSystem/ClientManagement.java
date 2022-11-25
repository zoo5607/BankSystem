package BankSystem;
//import java.lang.constant.Constable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ClientManagement extends BankVO{

    private String name; //이름
    private String accountNum; //계좌 번호
    private String balance;  //잔고
    private String transactionDate ; // 거래 일자
    //    private LocalDateTime transactionTime ; // 거래 시간
    private boolean isDeposit;  // 입금
    private boolean isWithdrawal; // 출금
    private String transactionAmount; // 거래 금액
    private String bankName; // 은행명

    private int money;    // 금액

    public ClientManagement(String name, String bankName, String accountNum, String balance, int money, String tradeTime, boolean isDeposit, boolean isWithdrawal) {
        super(name, bankName, accountNum, balance, money, tradeTime, isDeposit, isWithdrawal);
    }


    public String getTransactionDate(){ return transactionDate; }
    public void setTransactionDate(String tradeDate){transactionDate=tradeDate;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(boolean isDeposit) {
        this.isDeposit = isDeposit;
    }

    public boolean getIsWithdrawal() {
        return isWithdrawal;
    }

    public void setIsWithdrawal(boolean isWithdrawal) {
        this.isWithdrawal = isWithdrawal;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {

        if(super.getIsDeposit()){
            return "이름: " + super.getName() + "|" + "은행명: " + super.getBankName() + "|"+ "계좌번호: " + super.getAccountNum()+"|" +
                    "입금액: " + super.getMoney() + "|" + "잔고: " + super.getBalance()+ "| " + super.getTransactionDate();
        } else if (super.getIsWithdrawal()) {
            return "이름: " + super.getName() + "|" + "은행명: " + super.getBankName() + "|"+ "계좌번호: " + super.getAccountNum()+"|" +
                    "출금액: " + super.getMoney() + "|" + "잔고: " + super.getBalance()+ "| " + super.getTransactionDate();
        }
        else{
            return null;
        }

    }




    // 출금 후 잔고 = 기존잔고 - 거래금액
    // 입금 후 잔고 = 기존잔고 + 거래금액

}