package org.example;

class App {
  private static final String QUEUE_NAME = "MyFirstActiveMQ";

  public static void main(String[] args) throws Exception {
    SimpleQueue queue = new SimpleQueue(QUEUE_NAME);
    queue.send("Welcome to the World of ActiveMQ. Hope you will enjoy this tutorial.");
    queue.close();
  }
}
