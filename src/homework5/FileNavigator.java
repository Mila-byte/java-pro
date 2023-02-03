package homework5;

import homework5.utils.SizeComparator;

import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private final Map<String, List<FileData>> directory = new HashMap<>();

    public void add(FileData file) {
        directory.computeIfAbsent(file.path(), s -> new ArrayList<>()).add(file);
    }

    public void add(FileData file, String path) {
        if (file.path().equals(path)) {
            add(file);
        } else {
            System.out.println("path is not right");
        }
    }

    public List<FileData> filterBySize(int size) {
        return directory.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.size() < size)
                .sorted(Comparator.comparingInt(FileData::size))
                .toList();
    }


    public List<FileData> find(String path) {
        return directory.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.path().equals(path))
                .toList();
    }

    public void remove(String path) {
        directory.remove(path);
    }

    public List<FileData> sortFiles() {
        return directory.values().stream().flatMap(Collection::stream).sorted(new SizeComparator()).collect(Collectors.toList());
    }

    public Map<String, List<FileData>> getFiles() {
        return directory;
    }
}
