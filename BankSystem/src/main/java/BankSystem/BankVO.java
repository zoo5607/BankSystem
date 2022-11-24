package BankSystem;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankVO {

    private String name; //이름
    private String accountNum; //계좌 번호
    private String balance;  //잔고
    private Date transactionDate; // 거래 일자
    private Date transactionTime; // 거래 시간
    private String isDeposit;  // 입금
    private String isWithdrawal; // 출금
    private String transactionAmount; // 거래 금액
    private String bankName; // 은행명

    public BankVO(String name, String accountNum, String balance, Date transactionDate, Date transactionTime, String isDeposit, String isWithdrawal, String transactionAmount, String bankName) {
        this.name = name;
        this.accountNum = accountNum;
        this.balance = balance;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.isDeposit = isDeposit;
        this.isWithdrawal = isWithdrawal;
        this.transactionAmount = transactionAmount;
        this.bankName = bankName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public void setIsDeposit(String isDeposit) {
        this.isDeposit = isDeposit;
    }

    public void setIsWithdrawal(String isWithdrawal) {
        this.isWithdrawal = isWithdrawal;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getBalance() {
        return balance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public String getIsDeposit() {
        return isDeposit;
    }

    public String getIsWithdrawal() {
        return isWithdrawal;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public String toString(){
        Date date = new Date();
        SumpleDateFormat sdf = null;
        if()

    }
}
