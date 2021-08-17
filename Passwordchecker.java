import java.util.*;

public class Passwordchecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" Please enter a Password: ");
        String password = input.next();
        if (PasswordValid(password)) {
            System.out.println("The password is Valid");
            // Correct password
            if (password.equals("Software27")) {
                System.out.println("Welcome to the Server");
            } else {
                System.out.println("The password is not correct");
            }
        } else {
            System.out.println("The password is not Valid");
        }
    }

    public static boolean PasswordValid(String password) {
        //Password must match
        // 8 characters minimum
        // Letters digits and symbols
        // 2 digits minimum
        int len = password.length();
        if (len < 8) {
            System.out.println("The password you entered is too short");
            return false;
        } else {
            char charactercheck;
            int digitcount = 0;
            for (int i = 0; i < len; i++) {
                charactercheck = password.charAt(i);
                if (!Character.isLetterOrDigit(charactercheck)) {
                    return false;
                }
                if (Character.isDigit(charactercheck)) {
                    digitcount++;
                }
            }
            if (digitcount < 2) {
                System.out.println("You need at least 2 digits");
                return false;
            }
            return true;
        }
    }
}

        //    System.out.println("Continue with Password Check");
        //    }
        //}
        //if (password== "Software27."){
        //    System.out.println("Welcome");
        //else {
        //    System.out.println("The password is incorrect")
        //    }




