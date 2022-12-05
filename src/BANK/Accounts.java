package BANK;

import BANK.BankAccount;

public interface Accounts {
      public void  write_DAta();
      void display_Data();
      static int  search_Data(){return(0);};
      void modify_Data();
      static void deposit(){};
      static void withdraw(){};
}
