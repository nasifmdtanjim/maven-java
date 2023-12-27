package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public static String toJson(Object object) {
    return GSON.toJson(object);
  }
}
