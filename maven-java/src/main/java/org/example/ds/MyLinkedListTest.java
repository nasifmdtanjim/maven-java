package org.example.ds;

import java.util.ArrayList;
import java.util.List;

class MyLinkedListTest {
  public static void main(String[] args) throws Exception {
    final Character[] arrab = {'a', 'b'};
    final Character[] arrbc = {'b', 'c'};
    final Character[] arrcd = {'c', 'd'};
    final Character[] arrde = {'d', 'e'};

    final List<Character[]> list = new ArrayList<>(4);
    list.add(arrab);
    list.add(arrbc);
    list.add(arrcd);
    list.add(arrde);

    for (int i = 0; i < 5; i++) {
      MyLinkedList link = new MyLinkedList();
      link.add("A");
      link.add("B");
      link.add("C");
      link.add("D");

      link.add("E", i);

      System.out.println("E: " + i);
      System.out.println();
      System.out.println(link);
      System.out.println();
    }
  }
}
