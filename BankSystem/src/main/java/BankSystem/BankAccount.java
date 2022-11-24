package BankSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    Scanner sc = new Scanner(System.in);
    List<BankVO> bankusers = new ArrayList<>();
    public void run() {

        int key = 0;
        while ((key = menu()) != 0) {
            switch (key) {
                case 1: accountCreate();
                    break;
                case 2: accountManagement();
                    break;
                case 3: accountUpdate();
                    break;
                case 4: accountDelete();
                }
            }
        }


    private void accountCreate() {
            sc.nextLine();
            String name = getStrInput("이름: ");
            String bankName = getStrInput("은행명: ");
            String accountNum = getStrInput("계좌번호: ");
            String isDeposit = getStrInput("입금금액: ");

            bankusers.add(new BankVO(name,bankName,accountNum,isDeposit));
            System.out.println("계좌 등록 성공");
            }

    private void accountManagement() {
            int key = 0;
            while ((key = clientmenu()) != 0) {
                switch (key) {
                    case 1: clientManagement();
                        break;
                    case 2: clientList();
                        break;
                }
            }
        }
        private void clientManagement() {

        }
        private void clientList(){
            Iterator<BankVO> ite = bankusers.iterator();

            while (ite.hasNext()) {
                System.out.println(ite.next() + " ");
            }
        }

        private void accountUpdate() {
            if (bankusers.isEmpty()) {
                System.out.println("고객명이 없습니다.");
                return;
            }
            System.out.println("수정하실 고객명을 입력해주세요.");
            Scanner scanner = new Scanner(System.in);

            String bankName = scanner.nextLine();

            for (int i =0; i<bankusers.size();i++){
                if (bankName.equals(bankusers.get(i).getBankName())){
                    System.out.println("계좌번호를 입력해 주세요");
                    String accountNum = scanner.nextLine();
                    if(accountNum.equals(bankusers.get(i).getAccountNum())){
                        System.out.println("새로운 은행을 입력해 주세요");
                        String newBank = scanner.nextLine();
                        bankusers.get(i).setBankName(newBank);
                        System.out.println("수정이 완료 되었습니다.");
                        return;
                    }else{
                        System.out.println("계좌번호가 틀립니다.");
                    }

                }
            }
            System.out.println("회원 정보가 없습니다.");
        }
        private void accountDelete() {
            sc.nextLine();
            String name = getStrInput("삭제할 이름 :");

            for(int i = 0; i<bankusers.size(); i++ ){
                if(name == bankusers.get(i).getName()){
                    bankusers.remove(i);
                    System.out.println("삭제되었습니다.");
                } else {
                    System.out.println("정보와 맞지 않습니다.");
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
    private int menu() {
        System.out.println("=========================Bank System===================");
        return getNumInput("| 1.은행등록 | 2.은행관리 | 3.은행수정 | 4.은행삭제 | 0.종료 |");
    }
    private int clientmenu() {
        System.out.println("=========Client Management=========");
        return getNumInput("| 1.계좌관리 | 2.계좌목록 | 0.종료 |");
    }
}



