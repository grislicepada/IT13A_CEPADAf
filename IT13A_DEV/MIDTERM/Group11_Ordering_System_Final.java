package arsyarts_orderingsystem;

// import static MIDTERM.EncryptFileHandling.encryptMessage;
// import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Group11_Ordering_System_Final {
    
    public static void createAccount() { //METHOD FOR CREATEACCOUNT
        Scanner scanner = new Scanner(System.in);

        String username = "";
        String password = "";

        System.out.println("\nC R E A T E   N E W   A C C O U N T");
        System.out.print("Enter new username: ");
        username = scanner.nextLine();
        System.out.print("Enter new password: ");
        password = scanner.nextLine();

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Ryan\\OneDrive\\Documents\\users.txt", true); //ADD THE TRUE HERE TO STORE MULTIPLE ACCOUNTS AND WON'T UPDATE THE EXISTING ACCOUNT
            int key = 3;
            
            String encryptedPassword = encryptMessage(password, key);
            myWriter.write(username + "," + encryptedPassword + "\n");
            myWriter.close();
            System.out.println("\nAccount created successfully!");
            login();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the account.");
            e.printStackTrace();
        }
    }
    
    
    public static void login() { //METHOD FOR lOG IN
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nL O G I N");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        try {
            java.io.FileReader fileReader = new java.io.FileReader("C:\\Users\\Ryan\\OneDrive\\Documents\\users.txt");
            java.util.Scanner fileScanner = new java.util.Scanner(fileReader);

            String storedUsername = ""; //INITIALIZED FOR GETTING THE USERNAME VALUE FROM THE TEXT DOCUMENT
            String encryptedPassword = ""; //INITIALIZED FOR GETTING THE PASSWORD VALUE FROM THE TEXT DOCUMENT

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // ONCE MAKA DETECT UG COMMA, TUNGA-ON NIYA ANG LINE INTO TWO PARTS (LEFT UG RIGHT)
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    storedUsername = parts[0]; //PART 1 IS LEFT, THE USERNAME
                    encryptedPassword = parts[1]; //PART 2 IS RIGHT, THE PASSWORD
                }
            }

            fileScanner.close();
            fileReader.close();

            // Decrypt password
            int key = 3;
            String decryptedPassword = decryptMessage(encryptedPassword, key); //PARA E DECRYPT ANG ENCRYPTED NGA PASSWORD, PARA MAKA LOGIN

            // Validate credentials
            if (username.equals(storedUsername) && password.equals(decryptedPassword)) {
                System.out.println("\nLogin successful!\n");
                menu();
                return;
            } else {
                System.out.print("\nInvalid username or password. Please try again.\n\n[1] No account yet?\n[2] Back to login\nEnter choice: ");
                int redirection = scanner.nextInt();
                
                if(redirection == 1){
                    createAccount();
                }else if(redirection == 2){
                    login();
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred during login.");
            e.printStackTrace();
        }
    }


    public static String encryptMessage(String message, int key) { //METHOD FOR ENCRYPTING PASSWORD
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }


    public static String decryptMessage(String message, int key) { //METHOD FOR DECRYPTING PASSWORD
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
        }
        return new String(chars);
    }
    

    
    public static void menu(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" ------------------------- ");
        System.out.println("     W E L C O M E ");
        System.out.println("        TO OUR ");
        System.out.println("   R E S T A U R A N T");
        System.out.println(" ------------------------- ");
        
        //ARRAY VARIABLES, MULTIPLE VALUES EACH VARIABLES
        String[] foodsOptions = {"Chicken Adobo", "Humba", "Fried Chicken"};
        String[] drinksOptions = {"Lemonade", "Iced Tea", "Mango Shake"};
        double[] foodsPrices = {50.00, 80.00, 35.00};
        double[] drinksPrices = {65.00, 45.00, 35.00};
        
        String foodsOptionsPrint = ""; //TO GATHER OR COMPILE ALL THE VALUES IN FOODS ARRAY INTO ONE COPY
        String drinksOptionsPrint = ""; //TO GATHER OR COMPILE ALL THE VALUES IN DRINKS ARRAY INTO ONE COPY
        String choosingLabel = ""; //CUSTOMIZE CHOOSE LABEL DEPENDING ON THE COUNT OF ORDERS
        String currentOrders = ""; //TO COLLECT ALL CURRENT ORDERS WHILE STILL ORDERING TO VIEW ORDERED ITEMS
        String ordersPrint = ""; //TO GATHER OR COMPILE ALL THE FOODS OR DRINKS ORDERED TOGETHER WITH THEIR PRICES INTO ONE COPY
        String pcs = ""; //DISPLAYS PC FOR SINGULAR AND PCS FOR PLURAL
        int menuOptionsCount = 1; //THE NUMBER BEFORE THE FOODS AND DRINKS
        int menuOptionsChoice = 0; //THE SELECTED NUMBER OF THE CUSTOMER
        int menuOptionsQuantity = 0; //THE NUMBER OF HOW MANY ITEMS ARE ORDERED
        int m = 0; //INCREMENT TO TARGET INDEXES IN ARRAY
        int o = 0; //INCREMENT TO DETERMINE HOW MANY TIMES THE CUSTOMER REPEATS ORDERING
        
        double Total = 0;
        
        do{ //JUST TO PRINT ALL FOODS FROM THE ARRAY IN ONE COPY
            foodsOptionsPrint = foodsOptionsPrint + ("[" + menuOptionsCount + "] " + foodsOptions[m] + " - P" + foodsPrices[m]) + "\n";
            menuOptionsCount++;
            m++;
        }while(m < foodsOptions.length);
        m=0;
        do{ //JUST TO PRINT ALL DRINKS FROM THE ARRAY IN ONE COPY
            drinksOptionsPrint = drinksOptionsPrint + ("[" + menuOptionsCount + "] " + drinksOptions[m] + " - P" + drinksPrices[m]) + "\n";
            menuOptionsCount++;
            m++;
        }while(m < drinksOptions.length);
        
        do{
            o++;
            
            //CUSTOMIZED PARA SA PLURAL AND SINGULAR
            if(o == 1){
                choosingLabel = "Choose an item: "; //KUNG WALA PAKAY NA ORDER
            }else{
                choosingLabel = "\nChoose another item: "; //KUNG NAA NAKAY NA ORDER
                if(o == 2){
                    currentOrders = "\nCurrent order:\n" + ordersPrint + "Total bill: p"+ Total; //IF OPRDER IS ONLY ONE
                }else{
                    currentOrders = "\nCurrent orders:\n" + ordersPrint + "Total bill: p"+ Total; //IF ORDERS ARE MANY
                }
            }
            
            System.out.print("\nFOODS:\n" + foodsOptionsPrint + "DRINKS:\n" + drinksOptionsPrint + ("[" + menuOptionsCount + "] Exit\n") + currentOrders + "\n" + choosingLabel); //DISPLAYS ALL THE FOODS OPTIONS
            menuOptionsChoice = scanner.nextInt(); //CHOOSE BETWEEN THE CHOICES FROM THE FOODS OPTIONS

            if(menuOptionsChoice < menuOptionsCount && menuOptionsChoice > 0 ){ //IF THE CHOICE ENTERED IS AMONG THE NUMBERS IN MENU (or valid)
                
                System.out.print("Enter quantity: ");
                menuOptionsQuantity = scanner.nextInt();
                
                if(menuOptionsQuantity == 1){
                    pcs = "pc ";
                }else{
                    pcs = "pcs";
                }

                //CURRENT ORDERS PART
                if(menuOptionsChoice <= foodsOptions.length){ //IF CUSTOMERS' CHOICE IS 1 OR 2 OR 3, IT PRINTS THE FOODS
                    ordersPrint = ordersPrint + menuOptionsQuantity + pcs + " " + foodsOptions[menuOptionsChoice-1] + " - p" + (foodsPrices[menuOptionsChoice-1]*menuOptionsQuantity) + "\n";
                    Total = Total + (foodsPrices[menuOptionsChoice-1] * menuOptionsQuantity);
                }else{ //IF CUSTOMERS' CHOICE IS 4 OR 5 OR 6, IT PRINTS THE DRINKS
                    ordersPrint = ordersPrint + menuOptionsQuantity + pcs + " " + drinksOptions[(menuOptionsChoice-1)-foodsOptions.length] + " - p" + ((drinksPrices[(menuOptionsChoice-1)-foodsPrices.length])*menuOptionsQuantity) +"\n";
                    Total = Total + (drinksPrices[(menuOptionsChoice-1)-foodsPrices.length] * menuOptionsQuantity);

                }
            }else{ //IF THE CHOICE ENTERED IS NOT AMONG THE NUMBERS IN MENU
                if(menuOptionsChoice == menuOptionsCount){ //IF THE CHOICE ENTERED IS THE NUMBER FOR EXIT
                    payment(Total, ordersPrint); //PASSING THE TOTAL AND ORDERSPRINT (PARAMETERS) TO THE PAYMENT METHOD
                }else{ //IF THE CHOICE ENTERED IS not AMONG THE NUMBERS IN MENU AND NOT THE NUMBER FOR EXIT BUT OTHER INVALID CHOICE
                    System.out.println("\nYou've entered an invalid choice. Please try again.\n");
                }
                o--;
            }

        }while(menuOptionsChoice < menuOptionsCount || menuOptionsChoice > menuOptionsCount || menuOptionsChoice < 1);
        
        
//        System.out.println("\n\n---OFFICIAL RECEIPT---\n\n" + ordersPrint + "\nTotal bill: p" + Total + "\n\nThank you!");

    }
    
    
    
    public static void payment(double Total, String ordersPrint){ //RECEIVING THE TOTAL AND ORDERSPRINT AS PARAMETERS HERE IN THIS METHOD
        Scanner scanner = new Scanner(System.in);
        double money = 0;
        System.out.println("\n---PAYMENT---\n");
        
        do{
            System.out.print("Enter amount: ");
            money = scanner.nextDouble();

            if(money < Total){
                System.out.println("\nPlease enter sufficient amount.\n");
            }else{
                System.out.println("\n\n---OFFICIAL RECEIPT---\n\n" + ordersPrint + "\nTotal bill: p" + Total + "\nAmount: p" + money + "\nChange: p" + (money - Total) + "\n\nThank you!");
            }
        }while(money < Total);
    }
    
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] landingOptions = {"Log in", "Create Account"};
        
        String landingOptionsPrint = ""; //TO PRINT ALL VALUES OF THE LANDINGOPTIONS INTO ONE COPY
        int landingOptionsChoice = 0; //CHOICE OF THE USER WHETHER TO LOGIN OR CREATE ACCOUNT
        int landingOptionsCount = 1; //COUNT OF THE LANDING OPTIONS OR THE NUMBER BEFORE THE OPTIONS
        int i = 0; //JUST TO INCREMENT TO PRINT ALL THE LANDING OPTIONS FROM THE ARRAY
        
        do{ //JUST TO PRINT ALL LANDING OPTIONS FROM THE ARRAY
            landingOptionsPrint = landingOptionsPrint + ("[" + landingOptionsCount + "] " + landingOptions[i]) +"\n";
            landingOptionsCount++;
            i++;
        }while(i < landingOptions.length);

        
            System.out.print(landingOptionsPrint + "Enter choice: "); //DISPLAYS ALL THE LANDING OPTIONS
        landingOptionsChoice = scanner.nextInt(); //CHOOSE BETWEEN THE CHOICES FROM THE LANDING OPTIONS
        
        
        
        
        if (landingOptionsChoice == 1){ //DIRECTS TO LOGIN
            login();
        }else if (landingOptionsChoice == 2){ //DIRECTS TO REGISTRATION
            createAccount();
        }else{
            System.out.println("\nYou have entered an invalid choice. Please try again.");
            System.out.print(landingOptionsPrint + "Enter choice: "); //DISPLAYS ALL THE LANDING OPTIONS
            landingOptionsChoice = scanner.nextInt(); //CHOOSE BETWEEN THE CHOICES FROM THE LANDING OPTIONS
        }
        
    }
    
    
    
    
    
    
    
    
}

