import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        //Register page
        System.out.println("::::REGISTER::::");
        System.out.print("Enter number of accounts to register: ");
        int numOfAcc =  scan.nextInt();
        scan.nextLine();


        /* Stores the user credentials */
        String[] username = new String[numOfAcc];
        String[] password = new String[numOfAcc];

        for (int i = 0; i < numOfAcc; i++) {
            System.out.printf("Account %d\n", i);

            System.out.print("Enter username: ");
            username[i] = scan.nextLine();

            System.out.print("Enter password: ");
            password[i] = scan.nextLine();
        }

        System.out.println("""
                ACCOUNTS
                
                USERNAME        PASSWORD""");

        for (int i = 0; i < numOfAcc; i++) {
            System.out.printf("%-15s %-15s\n", username[i], password[i]);
        }


        boolean isLoginSuccess = false;
        int attempts = 3;
        boolean isMatch = false;

        System.out.println("::::LOGIN::::");

        while(attempts > 0 &&  !isLoginSuccess) {
            System.out.print("Username: ");
            String enteredUsername = scan.nextLine();

            System.out.print("Password: ");
            String enteredPassword = scan.nextLine();

            for(int i = 0; i < numOfAcc; i++) {
                if (enteredUsername.equals(username[i]) &&  enteredPassword.equals(password[i])) {
                    isMatch = true;
                    isLoginSuccess = true;
                    System.out.println("Login successful.");
                    break;
                }
            }

            if (!isMatch) {
                attempts--;
                System.out.println("Invalid username or password. Attempts: " + attempts);
            }
        }


    }
}