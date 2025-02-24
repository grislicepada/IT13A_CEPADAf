
package findthegreatestnumber;


import java.util.Scanner;
public class mainCepada {
    public static void main (String[]args){
    
       Scanner scanner = new Scanner(System.in);
            boolean u = true;
            while(u){
                
       System.out.println("Input the first number:");
       int x = scanner.nextInt();
       
       System.out.println("Input the second number:");
       int y = scanner.nextInt();
       
       System.out.println("Input the third number:");
       int z = scanner.nextInt();
    
            int greatest = Math.max(Math.max(x, y),z);
            
            System.out.println("The Greatest Number is:"+ greatest);
            
            System.out.println("\nDo you want to enter a new values? (Yes/No)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("No")){
                u= false;
            }
            System.out.println("\nProgram Ended");
            }
}
}