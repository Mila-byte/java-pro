package homework5.utils;

import homework5.FileData;

import java.util.Comparator;

public class SizeComparator implements Comparator<FileData> {
    public int compare(FileData s1, FileData s2) {
        return s1.getSize().compareTo(s2.getSize());
    }
}
