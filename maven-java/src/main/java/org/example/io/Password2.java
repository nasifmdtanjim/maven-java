package org.example.io;

import java.io.Console;
import java.util.Arrays;

class Password2 {

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.exit(1);
        }

        String login = console.readLine("Enter login: ");
        char[] oldPassword = console.readPassword("Enter old password: ");

        if (! isValidPassword(oldPassword)) {
            console.format("Wrong password given");
        }

        boolean noMatch;

        do {
            char[] newPassword1 = console.readPassword("Enter new password: ");
            char[] newPassword2 = console.readPassword("Confirm new password: ");
            noMatch = ! Arrays.equals(newPassword1, newPassword2);

            if (noMatch) {
                console.format("Passwords do not match. Please retry%n");
            } else {
                console.format("Password for %s changed%n", login);
            }

            Arrays.fill(newPassword1, ' ');
            Arrays.fill(newPassword2, ' ');
        } while (noMatch);

        Arrays.fill(oldPassword, ' ');
    }

    private static boolean isValidPassword(char[] oldPassword) {
        return true;
    }

}
