package org.example;

import java.util.ArrayList;
import java.util.List;

class SubModule {

    public SubModule() {
        this.numbers = new ArrayList<>();
    }

    private List<Integer> numbers;

    public void add(int number) {
        if (number != 0) {
            numbers.add(number);
        }
    }

    public int sum() {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public int product() {
        int product = 0;

        for (Integer number : numbers) {
            product *= number;
        }

        return product;
    }

    public void hello() {
        System.out.println("Hello Sub");
    }
}

