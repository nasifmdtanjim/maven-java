package org.example.io;

import java.io.File;

class ListDirectoryWithFilter {
    public static void main(String[] args) {
        File dir = new File(".");
        if (dir.isDirectory()) {
            listDirectoryWithFilter(dir);
        }
    }

	private static void listDirectoryWithFilter(File dir) {
        String[] files = dir.list((d, f) -> f.endsWith(".settings"));

        for (String file : files) {
            File fl = new File(file);
            fl.delete();
            System.out.println(file);
        }
	}
}
