package org.example;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        SubModule sub = new SubModule();

        sub.add(4);
        sub.add(5);

        int sum = sub.sum();

        System.out.println(sum);

        int product = sub.product();

        System.out.println(product);

        sub.hello();

        System.out.println();
    }
}

