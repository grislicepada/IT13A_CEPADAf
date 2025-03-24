
package MIDTERM;

import java.util.Scanner;
public class BasicCalculator {
      public static int addNum(int a , int b ){
        return a+b;
    }
    public static int subNum(int a , int b ){
        return a-b;
    }
      public static int multNum(int a , int b ){
        return a*b;
      }
     public static double divNum(double a , double b ){
        return a/b;
     }
      public static double percentNum(double a , double b ){
        return a%b;
      }
      
          public static void main(String[] args){
              Scanner s = new Scanner (System.in);
              
              System.out.println();
              int x = 27, y = 18;
              System.out.println("The addition: "+ addNum(x,y));
              System.out.println("The subtraction: "+ subNum(x,y));
              System.out.println("The multiplication: "+ multNum(x,y));
              System.out.println("The division: "+ divNum(x,y));
              System.out.println("The percentage: "+ percentNum(x,y));
          }

}
