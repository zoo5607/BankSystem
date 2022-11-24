package BankSystem;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BankVO {

    private String name; //이름
    private String accountNum; //계좌 번호
    private String balance;  //잔고
    private LocalDate transactionDate ; // 거래 일자
    private LocalDateTime transactionTime ; // 거래 시간
    private boolean isDeposit;  // 입금
    private boolean isWithdrawal; // 출금
    private String transactionAmount; // 거래 금액
    private String bankName; // 은행명

    public BankVO(String name, String bankName, String accountNum, String isDeposit) {
        this.name = name;
        this.accountNum = accountNum;
        this.balance = balance;
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalDateTime.now();
        this.isDeposit = isDeposit;
        this.isWithdrawal = isWithdrawal;
        this.transactionAmount = transactionAmount;
        this.bankName = bankName;
    }


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

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
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

    @Override
    public String toString() {
        return "이름: " +name + "|" + "은행명: " + bankName + "|"+ "계좌번호: " + accountNum+"|" + "입금액: " + isDeposit ;
    }

     // 출금 후 잔고 = 기존잔고 - 거래금액
    // 입금 후 잔고 = 기존잔고 + 거래금액

}