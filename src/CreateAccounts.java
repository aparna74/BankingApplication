//this program has two classes.first one is BankAccount class,which describes state and behaviour of a bank account.second one is
// AllAccounts class which creates a file and adds all the accounts details of a branch.should be run once bcz everytime it creates
// the file freshly.
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class CreateAccounts {
static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        Allaccounts.create_branch_names();
        while (true) {
            System.out.println("1  . Create accounts \n  2.Exit \n  3. Display Accounts");
            System.out.println("Enter option 1 or  2");
            option = sc.nextInt();
            if (option == 2) break;
            if (option == 1){
                try{
                    Allaccounts.create_Account(accounts);
                }catch(Exception e){
                    System.out.println("error in the data entered");
                }
            }
            if(option==3){
                for(BankAccount ba : accounts)
                    ba.display();
            }
        }
        transfer_data_file();
        sc.close();

    }

    private static void transfer_data_file()  {
        for (BankAccount ba :accounts) {
            try {String data = ba.getAccholdername() + "\t" + ba.getAccNo() + "\t" + ba.getBankname() + "\t" + ba.getBranchName() + "\t" + ba.getPhonenumber() + "\t" + ba.getBalance() +"\n";
               FileWriter fw = new FileWriter("D:\\Banking Application\\BankingApplication\\src\\AllAccounts.TXT",true);
               fw.write(data+"\n");
               fw.close();

            }catch(IOException ie){
               System.out.println("Error in input ");
            }
        }



        }


}

class Allaccounts{

    static ArrayList<String> branch_names  = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static void create_branch_names(){
        branch_names.add("attapur");
        branch_names.add("mehadipatnam");
        branch_names.add("hytechcity");
        System.out.println(branch_names);
    }
    static void create_Account(ArrayList<BankAccount> accounts)throws Exception{

        BankAccount acc =new BankAccount(readname_from_user(),readbranch_name_user(),readpnum_user(),readamount_user());
        accounts.add(acc);

     }



    static int countpnum(long pnum){
        int count=0;
        while(pnum !=0){
            pnum=pnum/10;
            count++;
        }
        return(count);
    }
    static String readname_from_user()throws Exception {

        while (true) {
            System.out.println("Enter Account holder's name");
            String name = sc.next();
            if (name.length() > 30) throw new NameException("length of the name <30");
            if (name.contains("\\w*[@!#$%^&*()+_]+\\w*"))
                throw new NameException("no special character allowed in the name");
            return (name);
        }
    }
    static String readbranch_name_user()throws Exception {
        String name;
        while (true) {
            System.out.println("branch name");
            try {
                name = sc.next();
                if (branch_names.contains(name)) break;
                else throw new NameException("branch  doesnot exists");
            } catch (NoSuchElementException e) {
                System.out.println("input mismatch");
            }

        }
        return(name);
    }
    static long readpnum_user() throws Exception{
        long pnum;
        while(true) {
                 System.out.println("enter phone number");
                 try {
                      pnum = sc.nextLong();
                     int length=Long.toString(pnum).length();
                     if(length!=10)
                         throw new NameException("phone number should have 10 digits ");
                     break;
                 } catch (NoSuchElementException e) {
                     System.out.println("input mismatch");
                 }
             }
             return(pnum);
    }
    static int readamount_user() throws Exception
    {      int amount;
             while(true){
                 System.out.println("enter amount");
                 try{
                      amount = sc.nextInt();
                     if(amount <500)throw new NameException("insufficient amount");
                     break;
                 }catch(NoSuchElementException e){
                     System.out.println("input mismatch");
                 }
             }
             return(amount);
    }
}






