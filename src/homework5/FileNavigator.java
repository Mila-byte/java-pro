package homework5;

import homework5.utils.SizeComparator;

import java.util.ArrayList;
import java.util.List;

public class FileNavigator {
    List<FileData> files = new ArrayList<>();

    public void add(String name, Byte size, String path) {
        if (files.size() == 0) {
            files.add(new FileData(name, size, path));
        } else {
            checkContainsFile(name, size, path);
        }
    }


    public List<FileData> find(String path) {
        List<FileData> foundFiles = new ArrayList<>();
        files.forEach(file -> {
            if (file.getPath().equals(path)) {
                foundFiles.add(file);
                System.out.println(file.getName());
            }
        });
        return foundFiles;
    }

    public List<FileData> filterBySize(Byte size) {
        List<FileData> verifiedFiles = new ArrayList<>();
        files.forEach(file -> {
            if (file.getSize() < size) {
                verifiedFiles.add(file);
            }
        });
        return verifiedFiles;
    }

    public void remove(String path) {
        files.removeIf(file -> file.getPath().equals(path));
    }

    public void sortFiles() {
        files.sort(new SizeComparator());
    }

    public List<FileData> getFiles() {
        return files;
    }

    private void checkContainsFile(String name, Byte size, String path) {
        if (!files.contains(new FileData(name, size, path))) {
            files.add(new FileData(name, size, path));
        } else {
            checkExistFile(path);
        }
    }

    private void checkExistFile(String path) {
        files.forEach(file -> {
            if (file.getPath().equals(path)) {
                System.out.println("file " + file.getName().toUpperCase() + " already exists in this directory");
            }
        });
    }
}
