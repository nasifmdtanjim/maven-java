package org.example.miscellaneous;

import static org.example.Util.toJson;

import java.util.ArrayList;
import java.util.List;

public class GsonExample {

  public static void main(String[] args) throws Exception {
    Character[] arrab = {'a', 'b'};
    Character[] arrbc = {'b', 'c'};
    Character[] arrcd = {'c', 'd'};
    Character[] arrde = {'d', 'e'};

    List<Character[]> list = new ArrayList<>();
    list.add(arrab);
    list.add(arrbc);
    list.add(arrcd);
    list.add(arrde);

    String json = toJson(list);

    System.out.println(json);
  }
}

