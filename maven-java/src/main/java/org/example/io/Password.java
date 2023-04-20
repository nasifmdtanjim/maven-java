package org.example.io;

import java.io.Console;
import java.util.Arrays;

class Password {

    public static void main(String[] args) {
        Console c = System.console();

        if (c == null) {
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char[] oldPassword = c.readPassword("Enter your password: ");

        if (isValidPassword(oldPassword)) {
            boolean noMatch;

            do {
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("Enter new password again: ");

                noMatch = Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again: %n");
                } else {
                    // change password
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);

            Arrays.fill(oldPassword, ' ');
        }
    }

    private static boolean isValidPassword(char[] password) {
        return true;
    }

}

