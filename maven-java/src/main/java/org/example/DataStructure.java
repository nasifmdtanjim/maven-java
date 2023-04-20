package org.example;

public class DataStructure {

    private int[] arrayOfInt = new int[SIZE];
    private static final int SIZE = 15;

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInt[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.printEven();
    }

    private class EvenIterator implements DataStructureIterator {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < SIZE - 1;
        }

        @Override
        public Integer next() {
            int val = arrayOfInt[nextIndex];
            nextIndex += 2;
            return val;
        }

    }

    interface DataStructureIterator extends java.util.Iterator<Integer>{};
}
