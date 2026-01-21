import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("::::REGISTER::::");
        System.out.print("Enter number of accounts to register: ");
        int accountCount =  scan.nextInt();
        scan.nextLine();

        String[] usernames = new String[accountCount];
        String[] passwords = new String[accountCount];

        for (int accountIndex = 0; accountIndex < accountCount; accountIndex++) {
            System.out.printf("Account %d\n", accountIndex);

            System.out.print("Enter username: ");
            usernames[accountIndex] = scan.nextLine();

            System.out.print("Enter password: ");
            passwords[accountIndex] = scan.nextLine();
        }

        System.out.println("""
                ACCOUNTS
                
                USERNAME        PASSWORD""");

        for (int accountIndex = 0; accountIndex < accountCount; accountIndex++) {
            System.out.printf("%-15s %-15s\n", usernames[accountIndex], passwords[accountIndex]);
        }


        boolean isLoginSuccessful = false;
        int REMAINING_ATTEMPTS = 3; // Constant Attempt value

        System.out.println("::::LOGIN::::");

        while(REMAINING_ATTEMPTS > 0 &&  !isLoginSuccessful) {
            System.out.print("Username: ");
            String enteredUsername = scan.nextLine();

            System.out.print("Password: ");
            String enteredPassword = scan.nextLine();

            boolean credentialsMatch = false; //Define if username and password are match together.

            for(int accountIndex = 0; accountIndex < accountCount; accountIndex++) {
                if (enteredUsername.equals(usernames[accountIndex]) &&
                        enteredPassword.equals(passwords[accountIndex])) {

                    credentialsMatch = true;
                    isLoginSuccessful = true;
                    System.out.println("Login successful.");
                    break;
                }
            }

            if (!credentialsMatch) {
                REMAINING_ATTEMPTS--;
                System.out.println("Invalid username or password. Attempts: " + REMAINING_ATTEMPTS);
            }
        }
    }
}