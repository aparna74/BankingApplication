class BankAccount {
    private String Accholdername;
    private long AccNo;
    private static final String Bankname = "Indian Bank";
    private static String BranchName;
    private long  Phonenumber;
    private int Balance;

   static  private  long Current_accno=100000104;
    static private long  acNo =Current_accno ;

    BankAccount(String name, String bname, long  pnum, int amount) {
        Accholdername = name;
        AccNo = ++acNo;
        BranchName = bname;
        Phonenumber = pnum;
        Balance = amount;
    }

    void credit(int amount) {
        Balance = Balance + amount;
    }

    void Debit(int amount) {
        Balance = Balance - amount;
    }

    void showBal() {
        System.out.println("Balance is : " + Balance);
    }
    long getAccNo() {
        return (AccNo);
    }
    String getAccholdername(){return Accholdername;}
    String getBankname(){return Bankname;}
    long getPhonenumber(){return Phonenumber;}
    String getBranchName(){return BranchName;}
    int getBalance(){return Balance;}


    void display() {
        System.out.println(Accholdername + "\t" +
                Bankname + "\t" +
                BranchName + "\t" +
                Phonenumber + "\t" +
                Balance + "\t" +
                AccNo);
    }


}
