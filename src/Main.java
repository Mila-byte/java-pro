import homework5.FileData;
import homework5.FileNavigator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        testAddMethod(fileNavigator);
        testFindMethod(fileNavigator);
        testFilterMethod(fileNavigator);
        testRemoveMethod(fileNavigator);
        testSortMethod(fileNavigator);
    }

    static private void testAddMethod(FileNavigator fileNavigator) {
        fileNavigator.add("index.js", (byte) 10, "documents/app");
        fileNavigator.add("index.js", (byte) 1, "documents/app/src");
        fileNavigator.add("main.java", (byte) 24, "documents/app/src");
        fileNavigator.add("something.java", (byte) 20, "documents/");
        fileNavigator.add("text.txt", (byte) 10, "documents/");
        fileNavigator.add("index.js", (byte) 50, "documents/app");
        fileNavigator.add("index.html", (byte) 47, "documents/app");
    }

    static private void testFindMethod(FileNavigator fileNavigator) {
        String path = "documents/app";
        List<FileData> foundFiles = fileNavigator.find(path);
        System.out.println("found files in" + " '" + path + "':");
        printFiles(foundFiles);
    }

    static private void testFilterMethod(FileNavigator fileNavigator) {
        Byte size = 20;
        List<FileData> filteredFiles = fileNavigator.filterBySize(size);
        System.out.println("filtered files by size " + size + ":");
        printFiles(filteredFiles);
    }

    static private void testRemoveMethod(FileNavigator fileNavigator) {
        String path = "documents/";
        System.out.println("before delete: ");
        printFiles(fileNavigator.getFiles());
        fileNavigator.remove(path);
        System.out.println("after delete: ");
        printFiles(fileNavigator.getFiles());
    }

    static private void testSortMethod(FileNavigator fileNavigator) {
        System.out.println("before sort: ");
        printFiles(fileNavigator.getFiles());
        fileNavigator.sortFiles();
        System.out.println("after sort: ");
        printFiles(fileNavigator.getFiles());
    }

    static private void printFiles(List<FileData> files) {
        files.forEach(file -> {
            System.out.println("- " + file.getName() + " " + file.getSize() + " " + file.getPath());
        });
    }
}