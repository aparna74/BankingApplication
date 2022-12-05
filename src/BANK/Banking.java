package BANK;

import BANK.Accounts_Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Banking  {

    public static void main(String[] args) throws IOException {
       Accounts_Database.establish_connection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int option = 0;
         while (true) {

            System.out.println(

                    """
                             1.   Display all account details
                             2.   Search by account number
                             3.   Deposit the amount
                             4.   Withdraw the amount
                             5.  exit 
                             
                            """);
            System.out.println("enter option");
            option = Integer.parseInt(br.readLine());
            switch (option){
                case 1:
                        Accounts_Database.display_Data();
                        break;
                case 2:Accounts_Database.search_Data();
                         break;
                case 3: Accounts_Database.deposit();
                         break;
                case 4: Accounts_Database.withdraw();
                        break;

                case 5: Accounts_Database.close_connection();
                    System.exit(0);


            }



            }
        }

        }











