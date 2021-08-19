import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Passwordchecker {
    static Map credentials = new HashMap();
    private static String inUsername;
    private static String inPassword;

    public static void main(String[] args) {
        System.out.println("Welcome to the Server!");
        createUser();
        while(createMoreUsers()){
            createUser();
        }
        serverLogin();
    }

    // Checks whether password is Valid;
    // Returns true or false
    public static boolean passwordValid(String password) {
        // 8 characters minimum
        // 15 characters maximum
        // 1 Uppercase Letter minimum
        // 1 Lowercase Letter minimum
        // 2 digits minimum
        int len = password.length();
        if (len < 8 && len > 15) return false;
        else {
            char charactercheck;
            int digitcount = 0;
            int LC_count = 0;
            int UC_count = 0;
            for (int i = 0; i < len; i++) {
                charactercheck = password.charAt(i);
                if (!Character.isLetterOrDigit(charactercheck)) {
                    return false;
                }
                if (Character.isDigit(charactercheck)) {
                    digitcount++;
                } else if (Character.isLowerCase(charactercheck)) {
                    LC_count++;
                } else if (Character.isUpperCase(charactercheck)) {
                    UC_count++;
                }
            }
            if (digitcount < 2) {
                return false;
            } else if (LC_count < 1) {
                return false;
            } else if (UC_count < 1) {
                return false;
            }
            return true;
        }

    }

    // Checks Password Strength
    // outputs Weak, Medium, Strong Password
    public static void passwordStrength(String password) {
        int passwordstrength = 0;
        int digitcount = 0;
        int UC_count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitcount++; //Counting the number of digits in password
            }
            if (Character.isUpperCase(password.charAt(i))) {
                UC_count++; //Counting the number of UpperCase Letters in passwords
            }
        }
        if (password.length() >= 10) {
            passwordstrength++;
        }
        if (digitcount >= 2) {
            passwordstrength++;
        }
        if (UC_count == 1) {
            passwordstrength++;
        }
        if (UC_count > 1) {
            passwordstrength += 2;
        }
        switch (passwordstrength) {
            case 1 -> System.out.println("Password Strength: Weak");
            case 2 -> System.out.println("Password Strength: Medium");
            case 3, 4 -> System.out.println("Password Strength: Strong");
            default -> System.out.println("Password is Weak");
        }
    }

    //Create User with Username & Password
    // Save Username & Password in credentials
    public static void createUser() {
        System.out.println("Please Enter Your Username: ");
        Scanner input = new Scanner(System.in);
        String username = input.next();
        System.out.println("Think of a password");
        System.out.println("The password must be 8-15 characters");
        System.out.println("The password must have at least 2 digits (0-9)");
        System.out.println("The password must contain at least 1 UpperCase Letter (A-Z)");
        System.out.println("The password must contain at least 1 LowerCase Letter (a-z)");
        Scanner input2 = new Scanner(System.in);
        System.out.println("Please enter the Password: ");
        String password = input.next();
        while (!passwordValid(password)) {
            System.out.println("Invalid password");
            System.out.println("Please enter a valid password:");
            input2 = new Scanner(System.in);
            password = input.next();
        }
        if (passwordValid(password)) {
            System.out.println("The password is Valid");
            passwordStrength(password);
            credentials.put(username, password);
        }
    }
    // Do you want to create more Users for the Server
    // Returns true or false based on User Input
    public static boolean createMoreUsers() {
        // Creating an ArrayList for possible User inputs
        ArrayList<String> decisionInput = new ArrayList<>();
        decisionInput.add("Yes");
        decisionInput.add("y");
        decisionInput.add("Y");
        decisionInput.add("True");
        decisionInput.add("yes");
        decisionInput.add("No");
        decisionInput.add("no");
        decisionInput.add("N");
        decisionInput.add("n");
        decisionInput.add("False");
        decisionInput.add("false");
        System.out.println("Do you want to create more Users");
        Scanner input = new Scanner(System.in);
        String decision = input.next();
        while (!decisionInput.contains(decision)) {
            System.out.println("Please Enter Yes or No");
            input = new Scanner(System.in);
            decision = input.next();
        }
        switch (decision) {
            case "Yes", "y", "yes", "Y", "True":
                return true;
            default:
                return false;
        }
    }
    // Ask Username
    public static void askUsername(){
        System.out.println("Please Enter Your Username");
        Scanner input = new  Scanner(System.in);
        String Username= input.next();
        inUsername = Username;

    }
    // Match Username
    private static void matchUsername(String inUsername){
        while (!credentials.containsKey(inUsername)){
            System.out.println("Incorrect Username");
            askUsername();
        }
        if (credentials.containsKey(inUsername)){
            System.out.println("Username Correct");
        }
    }
    // Ask Password
    public static void askPassword(String inUsername) {
        System.out.println("Please Enter the Username's Password: ");
        Scanner input = new Scanner(System.in);
        String newPasswordInput = input.next();
        inPassword = newPasswordInput;
    }

    // Match Password
    private static void matchPassword(String inUsername , String inPassword){
        int passwordCount= 4;
        while (!credentials.get(inUsername).equals(inPassword) && passwordCount> 0){
            System.out.println("Incorrect Password, Please try Entering password again");
            System.out.println( " You have" + " " + passwordCount + " " + "attempts left");
            Scanner input = new Scanner(System.in);
            inPassword= input.next();
            passwordCount--;
            if (passwordCount==0){
                System.out.println("You are out of attempts, Closing Server down!");
            }
        if (credentials.get(inUsername).equals(inPassword)){
            System.out.println("Password Correct");
            System.out.println("Welcome to the server");
        }
        }
    }
    // Login to the Server
    public static void serverLogin(){
        System.out.println("Lets try login to the Server");
        askUsername();
        matchUsername(inUsername);
        askPassword(inUsername);
        matchPassword(inUsername, inPassword);
        ;


    }
}


