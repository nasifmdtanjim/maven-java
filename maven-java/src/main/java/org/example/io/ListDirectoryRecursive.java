package org.example.io;

import java.io.File;

class ListDirectoryRecursive {
    public static void main(String[] args) {
        File dir = new File("/Users/nasif/dev/projects/maven-java/src/main/java/org/example");
        listRecursive(dir);
    }

	private static void listRecursive(File dir) {
        if (!dir.isDirectory()) {
            return;
        }

        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            System.out.println(file.getName()); 
            if (file.isDirectory()) {
                listRecursive(file);
            }
        }
	}
}
