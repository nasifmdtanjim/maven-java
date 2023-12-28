package org.example.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.example.ds.MyLinkedList.Node;

public class LinkListBuildParentChild {

  public static void main(String[] args) throws Exception {
    final Character[][] list = {
      {'a', 'b'},
      {'b', 'c'},
      {'c', 'd'},
      {'d', 'e'}
    };

    Map<Character, Node> seen = new HashMap<>();
    Set<Node> parentNode = new HashSet<>();

    for (Character[] item : list) {
      Node parent = null;
      if (! seen.containsKey(item[0])) {
        parent = new Node(item[0]);
        seen.put(item[0], parent);
        parentNode.add(parent);
      } else {
        parent = seen.get(item[0]);
        parentNode.remove(parent);
        seen.remove(item[0]);
      }

      Node child = null;
      if (! seen.containsKey(item[1])) {
        child = new Node(item[1]);
        seen.put(item[1], child);
      } else {
        child = seen.get(item[1]);
        seen.remove(item[1]);
      }

      parent.setNext(child);
    }

    Node node = parentNode.iterator().next();
    System.out.println(node);

    while (node.getNext() != null) {
      node = node.getNext();
      System.out.println(node);
    }
  }
}

