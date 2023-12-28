package org.example.ds;

public class MyLinkedList {
  private int size = 0;
  private Node first;
  private Node last;

  public void add(Object ob) {
    if (first == null) {
      first = new Node(ob);
      last = first;
    } else {
      last.next = new Node(ob);
      last = last.next;
    }

    size++;
  }

  public void add(Object ob, int index) {
    if (index == size) {
      last.next = new Node(ob);
      size++;
      return;
    } else if (index == 0) {
      Node node = new Node(ob);
      node.next = first;
      first = node;
      size++;
      return;
    }

    Node item = first;
    int i = 0;
    final int intIndexMinusOne = index - 1;
    do {
      if (i == intIndexMinusOne) {
        Node node = new Node(ob);
        node.next = item.next;
        item.next = node;
        break;
      }
      item = item.next;
      i++;
    } while (item.next != null);

    size++;
  }

  public Node getFirst() {
    return first;
  }

  public Node getLast() {
    return last;
  }

  @Override
  public String toString() {
    StringBuilder sbr = new StringBuilder(first.toString());
    Node item = first;
    do {
      sbr.append(System.lineSeparator());
      item = item.getNext();
      sbr.append(item);
    } while (item.getNext() != null);

    return sbr.toString();
  }

  public static class Node {
    Object ob;
    Node next;

    public Node(Object ob) {
      this.ob = ob;
    }

    public Object getObject() {
      return ob;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node node) {
      this.next = node;
    }

    @Override
    public String toString() {
      return ob.toString();
    }
  }
}
