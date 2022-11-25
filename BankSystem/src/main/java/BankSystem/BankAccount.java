package BankSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankAccount {
    static Scanner sc = new Scanner(System.in);
    static List<BankVO> bankusers = new ArrayList<>();
    static List<ClientManagement> transactionHistory = new ArrayList<>();
    // static HashMap<String, String> transactionHistory = new HashMap<>();

    public void run() { // 시스템메뉴

        int key = 0;
        while ((key = systemmenu()) != 0) {
            switch (key) {
                case 1:
                    accountCreate();
                    break;
                case 2:
                    accountManagement();
                    break;
                case 3:
                    accountDeposit();
                    break;
                case 4:
                    accountWithdrewal();
            }
        }
    }

    private void accountCreate() { //  은행 메뉴
        int key = 0;
        while ((key = bankmenu()) != 0) {
            switch (key) {
                case 1:
                    Create();
                    break;
                case 2:
                    Update();
                    break;
                case 3:
                    Delete();
                    break;
            }
        }
    }

    private void Create() { // 생성
        sc.nextLine();
        String name = getStrInput("이름: ");
        String bankName = getStrInput("은행명: ");
        String accountNum = getStrInput("계좌번호: ");

        bankusers.add(new BankVO(name, bankName, accountNum));
        System.out.println("계좌 등록 성공");
    }

    private void Update() { // 수정
        if (bankusers.isEmpty()) {
            System.out.println("고객명이 없습니다.");
            return;
        }
        System.out.println("수정하실 고객명을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        for (int i = 0; i < bankusers.size(); i++) {
            if (name.equals(bankusers.get(i).getName())) {
                System.out.println("계좌번호를 입력해 주세요");
                String accountNum = scanner.nextLine();
                if (accountNum.equals(bankusers.get(i).getAccountNum())) {
                    System.out.println("새로운 은행을 입력해 주세요");
                    String newBank = scanner.nextLine();
                    bankusers.get(i).setBankName(newBank);
                    System.out.println("수정이 완료 되었습니다.");
                    return;
                } else {
                    System.out.println("계좌번호가 틀립니다.");
                }
            }
        }
    }

    private void Delete() { // 삭제
        sc.nextLine();
        String name = getStrInput("삭제할 이름 :");

        for (int i = 0; i < bankusers.size(); i++) {
            if (name.equals(bankusers.get(i).getName())) {
                bankusers.remove(i);
                System.out.println("삭제되었습니다.");
            } else {
                System.out.println("정보와 맞지 않습니다.");
            }
        }
    }

    private void accountManagement() { // 고객메뉴
        int key = 0;
        while ((key = clientmenu()) != 0) {
            switch (key) {
                case 1:
                    clientManagement();
                    break;
                case 2:
                    clientList();
                    break;
            }
        }
    }

    private void clientManagement() { // 계좌 관리

        Iterator<ClientManagement> ite = transactionHistory.iterator();

        while (ite.hasNext()) {

            System.out.println(ite.next() + " ");


        }
    }

    private void clientList() { // 계좌 목록
        Iterator<BankVO> ite = bankusers.iterator();

        while (ite.hasNext()) {
            System.out.println(ite.next() + " ");
        }
    }

    private void accountDeposit() { // 예금
        sc.nextLine();
        String account = getStrInput("계좌 번호를 입력하세요. :");
        String tradeDate;
        int money = 0;      // 입금액
        int newBalance = 0; // 입금액이 더해질 새로운 잔고
        boolean isDeposit = false;
        boolean isAccountExist;


        for (int i = 0; i < bankusers.size(); i++) {

            if (account.equals(bankusers.get(i).getAccountNum())) { // 입력값과 기존 계좌번호가 동일한지 판별
                money = getNumInput("입금액 입력 :");
                newBalance = Integer.parseInt(bankusers.get(i).getBalance()) + money; // Integer.parseInt(String s) 문자열을 정수 값으로 변환 후
                // 입금 금액 더해 줌
                bankusers.get(i).setTransactionDate(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분").format(LocalDateTime.now()));
                bankusers.get(i).setMoney(money);
                bankusers.get(i).setBalance(String.valueOf(newBalance)); // String.valueOf() 숫자 값을 문자열로 변환
                tradeDate = bankusers.get(i).getTransactionDate();
                bankusers.get(i).setTransactionDate(tradeDate);

                isDeposit = true;
                bankusers.get(i).setIsDeposit(isDeposit);
                bankusers.get(i).setIsWithdrawal(false);
                transactionHistory.add(new ClientManagement(bankusers.get(i).getName(), bankusers.get(i).getBankName(),
                        account, String.valueOf(newBalance), money, tradeDate, bankusers.get(i).getIsDeposit(), bankusers.get(i).getIsWithdrawal()));
                // bankusers.get(i).transactionTime();
                System.out.println(money + "원이 입금되었습니다. 현재 잔액: " + bankusers.get(i).getBalance() + "원 입금날짜 :" + bankusers.get(i).getTransactionDate());

                break;
            } else {
                if (i < bankusers.size() - 1) {
                    continue;
                } else {
                    System.out.println("계좌 번호를 확인하세요.");
                }

            }
        }


    }

    private boolean checkAccountExist(int listIndex, String account) {

        // contains() 입력한 계좌번호가 존재하는지 판별
        return bankusers.get(listIndex).getAccountNum().contains(account);

    }

    private void accountWithdrewal() { // 출금
        sc.nextLine();
        String account = getStrInput("계좌 번호를 입력 :");
        String tradeDate;
        int money = 0;
        int newBalance = 0;

        for (int i = 0; i < bankusers.size(); i++) {

            if (account.equals(bankusers.get(i).getAccountNum())) { // 입력값과 기존 계좌번호가 동일한지 판별
                money = getNumInput("출금액 입력 :");
                newBalance = Integer.parseInt(bankusers.get(i).getBalance()) - money; // Integer.parseInt(String s) 문자열을 정수 값으로 변환 후
                // 입금 금액 더해 줌
                bankusers.get(i).setTransactionDate(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분").format(LocalDateTime.now()));

                bankusers.get(i).setMoney(money);
                bankusers.get(i).setBalance(String.valueOf(newBalance)); // String.valueOf() 숫자 값을 문자열로 변환
                tradeDate = bankusers.get(i).getTransactionDate();
                bankusers.get(i).setTransactionDate(tradeDate);


                bankusers.get(i).setIsDeposit(false);
                bankusers.get(i).setIsWithdrawal(true);
                transactionHistory.add(new ClientManagement(bankusers.get(i).getName(), bankusers.get(i).getBankName(),
                        account, String.valueOf(newBalance), money, tradeDate, bankusers.get(i).getIsDeposit(), bankusers.get(i).getIsWithdrawal()));
                // bankusers.get(i).transactionTime();
                System.out.println(money + "원이 출금되었습니다. 현재 잔액: " + bankusers.get(i).getBalance() + "원 입금날짜 :" + bankusers.get(i).getTransactionDate());

                break;
            } else {
                if (i < bankusers.size() - 1) {
                    continue;
                } else {
                    System.out.println("계좌 번호를 확인하세요.");
                }

            }
        }
    }

    private String getStrInput(String s) {
        System.out.println(s);
        return sc.nextLine();
    }

    private int getNumInput(String s) {
        System.out.println(s);
        return sc.nextInt();
    }


    private int systemmenu() {
        System.out.println(" /$$   /$$ /$$$$$$ /$$   /$$ /$$$$$$$$             /$$$$$$$   /$$$$$$  /$$   /$$ /$$   /$$\n" +
                "| $$$ | $$|_  $$_/| $$$ | $$| $$_____/            | $$__  $$ /$$__  $$| $$$ | $$| $$  /$$/\n" +
                "| $$$$| $$  | $$  | $$$$| $$| $$                  | $$  \\ $$| $$  \\ $$| $$$$| $$| $$ /$$/ \n" +
                "| $$ $$ $$  | $$  | $$ $$ $$| $$$$$               | $$$$$$$ | $$$$$$$$| $$ $$ $$| $$$$$/  \n" +
                "| $$  $$$$  | $$  | $$  $$$$| $$__/               | $$__  $$| $$__  $$| $$  $$$$| $$  $$  \n" +
                "| $$\\  $$$  | $$  | $$\\  $$$| $$                  | $$  \\ $$| $$  | $$| $$\\  $$$| $$\\  $$ \n" +
                "| $$ \\  $$ /$$$$$$| $$ \\  $$| $$$$$$$$            | $$$$$$$/| $$  | $$| $$ \\  $$| $$ \\  $$\n" +
                "|__/  \\__/|______/|__/  \\__/|________/            |_______/ |__/  |__/|__/  \\__/|__/  \\__/\n" +
                "                                                                                          \n" +
                "                                                                                          \n" +
                "                                                                     Copyright ⓒ 구해조.     ");
        System.out.println("*****************************************************************************************");
        return getNumInput("|     1.은행등록     |     2.은행관리     |     3.예금     |     4.출금     |     0.종료     |");
    }

    private int bankmenu() {
        System.out.println("*****************************************************************************************");
        return getNumInput("|        1.등록        |        2.수정       |       3.삭제       |        0.이전메뉴      |");
    }

    private int clientmenu() {
        System.out.println("*****************************************************************************************");
        return getNumInput("|          1.계좌관리          |          2.계좌목록          |          0.이전메뉴|          ");
    }


}


