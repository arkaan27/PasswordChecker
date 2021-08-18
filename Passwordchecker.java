package PasswordChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            PasswordStrength(password);
        }
        Map credentials = new HashMap();
        credentials.put(username, password);
        System.out.println("Do you want to create New User? ");
        Scanner n = new Scanner(System.in);
        boolean bn = n.nextBoolean();
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
            while (!PasswordValid(password2)) {
                System.out.println("Invalid password");
                System.out.println("Please enter a valid password:");
                input = new Scanner(System.in);
                password2 = input.next();
            }
            if (PasswordValid(password2)) {
                System.out.println("Valid Password");
                PasswordStrength(password2);
                credentials.put(username2, password2);
                System.out.println("Do you want to create another User? ");
                n = new Scanner(System.in);
                bn = n.nextBoolean();
            }
        }
        if (!bn) {
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
                while (!credentials.get(Loginusername).equals(newpasswordinput) && passwordcount > 0 ) {
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
    }
    public static boolean PasswordValid (String password){
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
    public static void PasswordStrength(String password){
        int passwordstrength= 0;
        int digitcount=0;
        int UC_count= 0;
        for (int i= 0; i<password.length();i++){
            if (Character.isDigit(password.charAt(i))) {
                digitcount++;
            }
            else if (Character.isUpperCase(password.charAt(i))) {
                UC_count++;
            }
        }
        if (password.length()>= 10 ) {
            passwordstrength++;
        }
        if (digitcount> 2 ) {
            passwordstrength++;
        }
        if (UC_count==1) {
            passwordstrength++;
        }
        if (UC_count>1){
            passwordstrength=passwordstrength+2;
        }
        switch(passwordstrength){
            case 1: System.out.println("Password Strength: Weak");
                break;
            case 2: System.out.println("Password Strength: Medium");
                break;
            case 3: System.out.println("Password Strength: Medium");
                break;
            case 4: System.out.println("Password Strength: Strong");
                break;
        }
    }
}
