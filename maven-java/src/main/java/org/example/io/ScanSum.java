package org.example.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class ScanSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        double sum = 0;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            scanner.useLocale(Locale.US);

            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += scanner.nextDouble();
                } else {
                    scanner.next();
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println(sum);
    }
}

