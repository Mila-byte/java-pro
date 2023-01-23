package homework5;

import java.util.Objects;

public class FileData {
    private String name;
    private Byte size;
    private String path;

    FileData(String name, Byte size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public Byte getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return Objects.equals(path, fileData.path) && Objects.equals(name, fileData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
