import java.io.*;

import java.util.*;
class BankingEx {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts  = new ArrayList<>();
    static  void file_to_array(){
        String line;
        try{
        FileReader fr = new FileReader("D:\\Banking Application\\BankingApplication\\src\\AllAccounts.TXT");
        BufferedReader br = new BufferedReader(fr);
          while((line=br.readLine())!= null) {
              String arr[] = line.split("\t");
              BankAccount ba = new BankAccount(arr[0], arr[2], Long.parseLong(arr[4]), Integer.parseInt(arr[5]));
              accounts.add(ba);
          }
        }catch(Exception e){
         System.out.println("input error");
        }
    }
    public static void main(String[] args)  {
        file_to_array();
        int option;
        while (true) {
            System.out.println(
                    """
                             1.   Display all account details
                             2.   Search by account number
                             3.   Deposit the amount
                             4.   Withdraw the amount
                             5.   Exit
                            """);
            System.out.println("enter option    \t ");
            option = sc.nextInt();
            if (option == 5) System.exit(0);
            if (option < 1 || option > 5) System.out.println("enter valid option");
            sc.reset();

            switch (option) {
                case 1 -> {
                    for (BankAccount acc : accounts) acc.display();
                }
                case 2 -> {
                    int index = dosearch();
                    if (index == -1) System.out.println("account does not exists");
                    else accounts.get(index).display();
                }
                case 3 -> {
                    int index = dosearch();
                    if (index == -1) System.out.println("account does not exists");
                    else {
                        System.out.println("enter amount to deposit");
                        int amount=sc.nextInt();
                        accounts.get(index).credit(amount);
                        accounts.get(index).display();
                    }
                }
                case 4->{
                    int index = dosearch();
                    if (index == -1) System.out.println("account does not exists");
                    System.out.println("enter amount to withdraw");
                    int amount=sc.nextInt();
                    accounts.get(index).Debit(amount);
                    accounts.get(index).display();
                }
            }


        }
    }

    static int dosearch() {
        System.out.println("Enter Account Number");
        long accno = sc.nextLong();
       return( SearchAccNum.search(accno, accounts));

    }
}






