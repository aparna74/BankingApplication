import java.util.ArrayList;

class SearchAccNum{
   static int  search(long accno, ArrayList<BankAccount> accounts) {
       int length = accounts.size();
       int startIndex = 0, endIndex = length - 1, midindex = length/2;

       while (midindex >= 0 && midindex <length &&endIndex >=0 ) {

           long midobj = accounts.get(midindex).getAccNo();
           if ( accno==midobj) return (midindex);
            if ( accno<midobj) endIndex = midindex - 1;
           else startIndex = midindex + 1;
           midindex =startIndex+( (endIndex - startIndex + 1) / 2);

       }
       return(-1);

   }

}