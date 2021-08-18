package PasswordChecker;
import java.util.*;
public class Passwordchecker {
    public static void main(String[] args) {
        System.out.println("Welcome to the Server");
        System.out.println("Lets create a Username: ");
        Scanner input1 = new Scanner(System.in);
        String username = input1.next();
        System.out.println("Think of a password");
        System.out.println("The password must be 8-15 characters");
        System.out.println("The password must have at least 2 digits (0-9)");
        System.out.println("The password must contain at least 1 UpperCase Letter (A-Z)");
        System.out.println("The password must contain at least 1 LowerCase Letter (a-z)");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Password: ");
        String password = input.next();
        while (!PasswordValid(password)) {
            System.out.println("Invalid password");
            System.out.println("Please enter a valid password:");
            input = new Scanner(System.in);
            password = input.next();
        }
        if (PasswordValid(password)) {
            System.out.println("The password is Valid");
            System.out.println("Lets try login to the Server");
            System.out.println("Please Enter Your Username: ");
            Scanner input2 = new Scanner(System.in);
            String Loginusername = input2.next();
            while (!username.equals(Loginusername)) {
                System.out.println("Incorrect Username, Please enter your Username again: ");
                input2 = new Scanner(System.in);
                Loginusername = input2.next();
            }
            if (username.equals(Loginusername)) {
                System.out.println("Username Correct, Please Enter the Password: ");
                Scanner input3 = new Scanner(System.in);
                String newpasswordinput = input3.next();
                int passwordcount = 4;
                while (!password.equals(newpasswordinput) && passwordcount > 0) {
                    System.out.println("Incorrect Password, Please try Entering password again:");
                    System.out.println("You have" + " " + passwordcount + " " + "attempts left ");
                    input3 = new Scanner(System.in);
                    newpasswordinput = input3.next();
                    passwordcount--;
                    if (passwordcount == 0) {
                        System.out.println("You are out of attempts, Closing Server down!");
                    }
                }
                if (password.equals(newpasswordinput)) {
                    System.out.println("Password Correct!");
                    System.out.println("Welcome to the Server!");
                }
            }
        }
    }
    public static boolean PasswordValid(String password) {
        //Password must match
        // 8 characters minimum 15 characters maximum
        // 1 Uppercase and 1 Lower case
        // Letters & digits
        // 2 digits minimum
        int len = password.length();
        if (len < 8 && len > 15) {
            return false;
        } else {
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
                }
                else if (Character.isLowerCase(charactercheck)) {
                    LC_count++;
                }
                else if (Character.isUpperCase(charactercheck)) {
                    UC_count++;
                }
            }
            if (digitcount < 2) {
                return false;
                }
            else if (LC_count < 1) {
                return false;
                }
            else if (UC_count < 1) {
                return false;
                }
            return true;
            }
        }
}




