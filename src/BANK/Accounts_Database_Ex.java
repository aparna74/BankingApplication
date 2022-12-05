package BANK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.io.IOException;
import java.sql.*;

    class Accounts_Database {// implements BANK.Accounts{
        static Connection con = null;
        static Statement stt;
        static ResultSet resultset=null;


        //@Override
        public void write_DAta() throws IOException {

            String name, bname, br_name;
            int bal;
            long accno, phno;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Account details");
            System.out.println("Enter Account holder's  name  : ");
            name = reader.readLine();
            System.out.print("\n Account number : ");
            accno = Long.parseLong(reader.readLine());
            System.out.print("\n Bank name :");
            bname = reader.readLine();

            System.out.print("\n Branch name :");
            br_name = reader.readLine();

            System.out.print("\n Phone number :");
            phno = Long.parseLong(reader.readLine());
            System.out.print("\n Balance  :");
            bal = Integer.parseInt(reader.readLine());
            // BankAccount ba = new BankAccount(name, accno, bname, br_name, phno, bal);
            try {
                PreparedStatement pst = con.prepareStatement("INSERT INTO  bankaccount (NAME,ACNO,BANK_NAME,BRANCH_NAME,PHONE_NUMBER,BALANCE )VALUES(?,?,?,?,?,?);");
                pst.setNString(1, name);
                pst.setLong(2, accno);
                pst.setNString(3, bname);
                pst.setNString(4, br_name);
                pst.setLong(5, phno);
                pst.setInt(6, bal);
                pst.executeUpdate();

                System.out.println("data entered into nmysql table bankaccount");
            } catch (Exception e) {
                System.out.println(e);
            }


        }

        static void establish_connection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Mysql@1974");

            } catch (Exception e) {
                System.out.println(e);
            }


        }

       static  void close_connection() {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void display_Data() {
            try {
                Statement st = con.createStatement();
                ResultSet resultSet = st.executeQuery("select * from bankaccount;");

                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String bname = resultSet.getString("BANK_NAME");
                    String brname = resultSet.getString("BRANCH_NAME");
                    Long acno = resultSet.getLong("ACNO");
                    Long phno = resultSet.getLong("PHONE_NUMBER");
                    int bal = resultSet.getInt("BALANCE");
                    System.out.println((name + "   " + acno + "   " + bname + "   " + brname + "   " + phno + "   " + bal));
                }
                }catch(SQLException e){
                    System.out.println(e);
                }
            }


   // @Override
    static int search_Data() {
       int bal=0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter account number");
            long acno = Long.parseLong(br.readLine());
            PreparedStatement pstt = con.prepareStatement("select DISTINCTROW * FROM bankaccount where ACNO = ?;");
             pstt.setLong(1,acno);
              resultset = pstt.executeQuery();
             resultset.next();
              bal = resultset.getInt(6);
             System.out.println(resultset.getString(1)+"  "+resultset.getLong(2)+"  "+resultset.getString(3)+"  "+resultset.getString(4)+"   "+resultset.getLong(5)+"   "+resultset.getInt(6));

        }catch(Exception e){
            System.out.println(e);

        }finally{

            return(bal);

        }


    }



        static void deposit() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("enter ACNO");
                long acno = Long.parseLong(br.readLine());
                System.out.println("enter deposit amount");
                int amount = Integer.parseInt(br.readLine());
                PreparedStatement pst = con.prepareStatement("UPDATE  bankaccount SET BALANCE = (BALANCE + ?) where ACNO= ?");

                pst.setInt(1,amount);
                pst.setLong(2,acno);
                pst.executeUpdate();
                System.out.println("updated balance");
                pst = con.prepareStatement("select * from bankaccount where ACNO = ?");
                pst.setLong(1,acno);
               ResultSet rs = pst.executeQuery();
               rs.next();
               System.out.println(rs.getString(1)+"  "+rs.getLong(2)+"  "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getLong(5)+"  "+rs.getInt(6));
            }catch(Exception e){
                System.out.println(e);
            }


        }





    static void withdraw() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("enter ACNO");
            long acno = Long.parseLong(br.readLine());
            System.out.println("enter deposit amount");
            int amount = Integer.parseInt(br.readLine());
            PreparedStatement pst = con.prepareStatement("UPDATE  bankaccount SET BALANCE = (BALANCE - ?) where ACNO= ?");
            pst.setInt(1,amount);
            pst.setLong(2,acno);
            pst.executeUpdate();
            System.out.println("updated balance");
            pst = con.prepareStatement("select * from bankaccount where ACNO = ?");
            pst.setLong(1,acno);
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.println(rs.getString(1)+"  "+rs.getLong(2)+"  "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getLong(5)+"  "+rs.getInt(6));

        }catch(Exception e){
            System.out.println(e);
        }


    }

        public class Accounts_Database_Ex {
            public static void main(String[] args) throws Exception {
                Accounts_Database accounts = new Accounts_Database();
                System.out.println("create accounts");
                accounts.establish_connection();
                accounts.write_DAta();
                accounts.close_connection();
            }

        }
    }








