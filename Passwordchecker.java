package PasswordChecker;

import java.util.*;

public class Passwordchecker {
    static Map credentials = new HashMap();

    public static void main(String[] args) {
        Map credentials = new HashMap();
        System.out.println("Welcome to the Server");
        System.out.println("Lets create a Username: ");
        Scanner input1 = new Scanner(System.in);
        String username = input1.next();
        askPassword(username);
        System.out.println("Do you want to create New User? ");
        Scanner n = new Scanner(System.in);
        String decision = n.next();
        boolean bn = false;
        stringToBoolean(decision);
        while (bn) {
            System.out.println("Lets create another Username");
            System.out.println("Please type in your Username");
            Scanner input3 = new Scanner(System.in);
            String username2 = input3.next();
            System.out.println("Think of a password");
            System.out.println("The password must be 8-15 characters");
            System.out.println("The password must have at least 2 digits (0-9)");
            System.out.println("The password must contain at least 1 UpperCase Letter (A-Z)");
            System.out.println("The password must contain at least 1 LowerCase Letter (a-z)");
            Scanner input4 = new Scanner(System.in);
            System.out.println("Please enter the Password: ");
            String password2 = input4.next();
            while (!passwordValid(password2)) {
                System.out.println("Invalid password");
                System.out.println("Please enter a valid password:");
                Scanner input = new Scanner(System.in);
                password2 = input.next();
            }
            if (passwordValid(password2)) {
                System.out.println("Valid Password");
                passwordStrength(password2);
                credentials.put(username2, password2);
                System.out.println("Do you want to create another User? ");
                n = new Scanner(System.in);
                decision = n.next();
                stringToBoolean(decision);
            }
        }
        System.out.println("Lets try login to the Server");
        System.out.println("Please Enter Your Username: ");
        Scanner input5 = new Scanner(System.in);
        String Loginusername = input5.next();
        while (!credentials.containsKey(Loginusername)) {
            System.out.println("Incorrect Username, Please enter your Username again: ");
            input5 = new Scanner(System.in);
            Loginusername = input5.next();
        }
        if (credentials.containsKey(Loginusername)) {
            System.out.println("Username Correct");
            System.out.println("Please Enter the Username's Password:");
            Scanner input6 = new Scanner(System.in);
            String newpasswordinput = input6.next();
            int passwordcount = 4;
            while (!credentials.get(Loginusername).equals(newpasswordinput) && passwordcount > 0) {
                System.out.println("Incorrect Password, Please try Entering password again.");
                System.out.println("You have" + " " + passwordcount + " " + "attempts left");
                input6 = new Scanner(System.in);
                newpasswordinput = input6.next();
                passwordcount--;
                if (passwordcount == 0) {
                    System.out.println("You are out of attempts, Closing Server down!");
                }
            }
            if (credentials.get(Loginusername).equals(newpasswordinput)) {
                System.out.println("Password Correct");
                System.out.println("Welcome to the server");
            }
        }

    }

    public static boolean passwordValid(String password) {
        //Password must match
        // 8 characters minimum 15 characters maximum
        // 1 Uppercase and 1 Lower case
        // Letters & digits
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

    public static void passwordStrength(String password) {
        //Password Strength Calculator
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

    public static void stringToBoolean(String decision) {
        String[] decisions = {"No", "no", "N", "False", "false", "n", "yes", "Yes", "Y", "True", "y", "true"};
        ArrayList<String> decisionInput = new ArrayList<>();
        decisionInput.addAll(Arrays.asList(decisions));
        boolean bn;
        while (!decisionInput.contains(decision)) {
            System.out.println("Please enter Yes or No");
            Scanner input9 = new Scanner(System.in);
            decision = input9.next();
        }
        if (decisionInput.equals(decision)) {
            switch (decision) {
                case "yes", "Yes", "Y", "True", "y" -> bn = true;
                case "No", "no", "N", "False", "false" -> bn = false;
                default -> System.out.println("You probably broke the system");
            }
        }
    }

    public static void askPassword(String username) {
        System.out.println("Think of a password");
        System.out.println("The password must be 8-15 characters");
        System.out.println("The password must have at least 2 digits (0-9)");
        System.out.println("The password must contain at least 1 UpperCase Letter (A-Z)");
        System.out.println("The password must contain at least 1 LowerCase Letter (a-z)");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Password: ");
        String password = input.next();
        while (!passwordValid(password)) {
            System.out.println("Invalid password");
            System.out.println("Please enter a valid password:");
            input = new Scanner(System.in);
            password = input.next();
        }
        if (passwordValid(password)) {
            System.out.println("The password is Valid");
            passwordStrength(password);
            credentials.put(username, password);
        }
    }

    public static void createNewUser(boolean bn) {

        System.out.println("Lets create another Username");
        System.out.println("Please type in your Username");
        Scanner input3 = new Scanner(System.in);
        String username2 = input3.next();
        System.out.println("Think of a password");
        System.out.println("The password must be 8-15 characters");
        System.out.println("The password must have at least 2 digits (0-9)");
        System.out.println("The password must contain at least 1 UpperCase Letter (A-Z)");
        System.out.println("The password must contain at least 1 LowerCase Letter (a-z)");
        Scanner input4 = new Scanner(System.in);
        System.out.println("Please enter the Password: ");
        String password2 = input4.next();
        while (!passwordValid(password2)) {
            System.out.println("Invalid password");
            System.out.println("Please enter a valid password:");
            Scanner input = new Scanner(System.in);
            password2 = input.next();
        }
        if (passwordValid(password2)) {
            System.out.println("Valid Password");
            passwordStrength(password2);
            credentials.put(username2, password2);
            System.out.println("Do you want to create another User? ");
            Scanner input = new Scanner(System.in);

        }
    }
}
