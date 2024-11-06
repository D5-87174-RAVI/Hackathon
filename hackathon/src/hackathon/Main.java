package hackathon;



import java.util.Scanner;



import java.util.HashMap;


public class Main {
    private static String CUR_USER = null; // Stores currently signed-in user's email
    private static HashMap<String, String> users = new HashMap<>(); // Stores users with email as key and password as value

    // Displays the menu for signed-in users, with options for addition and subtraction
    public static void userMenu(Scanner sc) {
        int choice;
        do {
            System.out.print("\n0. Exit\n1. Addition\n2. Subtraction\nEnter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // Addition
                    addition(sc);
                    break;
                case 2: // Subtraction
                    subtraction(sc);
                    break;
            }
        } while (choice != 0);
    }

    // Handles addition of two numbers
    private static void addition(Scanner sc) {
        System.out.print("Enter number1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter number2: ");
        int num2 = sc.nextInt();
        System.out.println("Addition Result: " + (num1 + num2));
    }

    // Handles subtraction of two numbers
    private static void subtraction(Scanner sc) {
        System.out.print("Enter number1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter number2: ");
        int num2 = sc.nextInt();
        System.out.println("Subtraction Result: " + (num1 - num2));
    }

    // Displays the main menu for signing in and signing up
    public static void mainMenu(Scanner sc) {
        int choice;
        do {
            System.out.print("\n0. Exit\n1. Sign In\n2. Sign Up\nEnter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // Sign In
                    CUR_USER = authenticate(sc);
                    if (CUR_USER != null) {
                        System.out.println("Welcome, " + CUR_USER + "!");
                        userMenu(sc);
                    } else {
                        System.out.println("Invalid Login.");
                    }
                    break;
                case 2: // Sign Up
                    registerUser(sc);
                    break;
            }
        } while (choice != 0);
    }

    // Handles user registration by prompting for email and password
    private static void registerUser(Scanner sc) {
        System.out.print("Enter email: ");
        String email = sc.next();
        
        // Check if email is already registered
        if (users.containsKey(email)) {
            System.out.println("Email already registered. Try a different email.");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = sc.next();
        
        // Store the new user’s email and password
        users.put(email, password);
        System.out.println("Registration successful! You can now log in.");
    }

    // Authenticates the user by checking if the provided credentials match any stored in the system
    private static String authenticate(Scanner sc) {
        System.out.print("Enter email: ");
        String email = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();
        
        // Verify the credentials
        if (users.containsKey(email) && users.get(email).equals(password)) {
            return email; // Return email as current user
        }
        
        return null; // Authentication failed
    }

    // Main method to initialize and run the application
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc); // Start with the main menu
        sc.close();
    }
}
