package org.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;

        int c;

        File file = new File(".");
        File[] files = file.listFiles();

        // for (File fl : files) {
        //     System.out.println(fl.getName());
        // }
        try {
            in = new FileInputStream("./pom.xml");

            while ((c = in.read()) != -1) {
                System.out.println(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
