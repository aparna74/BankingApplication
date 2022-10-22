import java.util.*;

public class  SortArraylist{

    public static int compareMylist(BankAccount o1, BankAccount o2) {
        if(o1.getAccNo() < o2.getAccNo())return(1);
        else if(o1.getAccNo() > o2.getAccNo())return(-1);
        else return(0);
    }
  static void  SortArray(ArrayList<BankAccount>  accounts  ){
          BankAccount  first,second,temp;
          for (int i=0;i<accounts.size();i++){
             first=accounts.get(i);
            for (int j=i+1;j<accounts.size();j++) {
                second=accounts.get(j);
                int k = compareMylist(first, second);
                if (k == -1) {
                     temp=accounts.get(i);
                    accounts.set(i,second);
                    accounts.set(j,temp);
                }

            }
        }
    }


    }

