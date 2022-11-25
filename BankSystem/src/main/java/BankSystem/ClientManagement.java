package BankSystem;
//import java.lang.constant.Constable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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



    /*public ClientManagement(String name, String bankName, String accountNum) {
        this.name = super.getName();
        this.accountNum = accountNum;
        this.balance = "10000";
        this.transactionDate = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분").format(LocalDateTime.now());
//        this.transactionTime = LocalDateTime.now();
        this.isDeposit = isDeposit;
        this.isWithdrawal = isWithdrawal;
        this.transactionAmount = transactionAmount;
        this.bankName = bankName;
        this.money = money;
    }*/

    /*public ClientManagement(String name, String bankName, String accountNum, String balance, int money, String tradeTime, boolean isDeposit, boolean isWithdrawal) {
        this.name = super.getName();
        this.accountNum = super.getAccountNum();
        this.balance = super.getBalance();
        this.transactionDate = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분").format(LocalDateTime.now());
//        this.transactionTime = LocalDateTime.now();
        this.isDeposit = super.getIsDeposit();
        this.isWithdrawal = super.getIsWithdrawal();
        //this.transactionAmount = transactionAmount;
        this.bankName = super.getBankName();
        this.money = super.getMoney();
    }*/

    /*public String createTranscationDate(){
        String date = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분").format(LocalDateTime.now());
        return date;
    }*/

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
//
//    public LocalDate getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(LocalDate transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    public LocalDateTime getTransactionTime() {
//        return transactionTime;
//    }
//
//    public void setTransactionTime(LocalDateTime transactionTime) {
//        this.transactionTime = transactionTime;
//    }

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