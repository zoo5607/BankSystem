package BankSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    static Scanner sc = new Scanner(System.in);
    static List<BankVO> bankusers = new ArrayList<>();
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

    }

    private void clientList() { // 계좌 목록
        Iterator<BankVO> ite = bankusers.iterator();

        while (ite.hasNext()) {
            System.out.println(ite.next() + " ");
        }
    }

    private void accountDeposit() { // 예금

    }

    private void accountWithdrewal() { // 출금

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
        System.out.println("=====================Bank System===================");
        return getNumInput("| 1.은행등록 | 2.은행관리 | 3.예금 | 4.출금 | 0.종료 |");
    }

    private int bankmenu() {
        System.out.println("========Bank Update / Delete=========");
        return getNumInput("| 1.등록 | 2.수정 | 3.삭제 | 0.종료 |");
    }

    private int clientmenu() {
        System.out.println("=========Client Management=========");
        return getNumInput("| 1.계좌관리 | 2.계좌목록 | 0.종료 |");
    }
}



