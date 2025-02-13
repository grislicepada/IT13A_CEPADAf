
package PRELIM;

//
import java.util.Scanner;

public class Activity1_Arithmetic_Operators {

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        // Input numbers
        System.out.println("Input first number: "); 
        int num1 = scanner.nextInt();
        
        System.out.println("Input second number: ");  
        int num2 = scanner.nextInt();
        
        System.out.println("Input third number: "); 
        int num3 = scanner.nextInt();
        
        int num5 = 44; //fixed nani kay libog, diri pa gani
        
        //mao pa gali ni kapoy na
        System.out.println(num1 + "*" + num2 + "+" + num3 + "=" + (num1*num2+num3));  
        System.out.println("(" + num1 + "-" + num2 + ")%" + num3 + "=" + ((num1-num2)%num3));  
        System.out.println("(" + num1 + "+" + num2 + "+" + num3 + ")/3=" + ((num1+num2+num3)/3));  
        System.out.println(num1 + "*" + num3 + "-(" + num2 + "*" + num2 + ")=" + num5); 
     
        scanner.close();
    }
}



        


        
               
              
    
       
        
  
        
    
    

    


