package org.example.io;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.SortedMap;

class TestCharset {

    public static void main(String[] args) {
        System.out.println("The default character set is: " + Charset.defaultCharset());
        System.out.println("The default character set is: " + System.getProperty("file.encoding"));

        SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
        Collection<Charset> values = availableCharsets.values();

        values.forEach(charset -> System.out.println(charset.name()));

        System.out.println(Charset.isSupported("UTF-8"));  // true
        System.out.println(Charset.isSupported("UTF8"));   // true
        System.out.println(Charset.isSupported("UTF_8"));

        Charset charset = Charset.forName("UTF-8");
        System.out.println(charset.name());
        System.out.println(charset.aliases());
    }

}
