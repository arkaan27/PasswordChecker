import java.util.*;

public class Passwordchecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" Please enter a Password: ");
        String password = input.next();
        int len = password.length();
        if (PasswordValid(password)) {
            System.out.println("The password is Valid");
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
            int count = 1;
            for (int i = 0; i < len; i++) {
                charactercheck = password.charAt(i);
                if (!Character.isLetterOrDigit(charactercheck)) {
                    return false;
                }
                if (Character.isDigit(charactercheck)) {
                    count++;
                    if (count < 1) {
                        System.out.println("You need to input at least 2 digits");
                        return false;
                    }

                }
            }
        }
        return true;
    }
    public static void PasswordCorrect(String password){
        // Correct password
        if (password == "Software27") {
            System.out.println("Welcome to the Server");
        }
        else {
            System.out.println("The password is Incorrect");
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




