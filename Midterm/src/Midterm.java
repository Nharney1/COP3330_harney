import java.awt.*;

public class Midterm {

     public static void main(String[] args) {

         Contact me = new Contact("noah", "noah email", "noah number");

         System.out.println(me.toString());

         me.setEmail("new email");
         me.setName("New name");

         System.out.println(me.toString());

       //  System.out.println(sumOdds(10));
    }

   /* public static int sumOdds(int n){
         int sum =0;
         for(int i=1; i <= n; i+=2){
             sum += i;
         }
         return sum;
    }

    */
}
