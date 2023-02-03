import homework5.FileData;
import homework5.FileNavigator;

public class Main {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(new FileData("file", (byte) 2, "path/to/file"));
        fileNavigator.add(new FileData("file", (byte) 2, "path/to33/file"));
        fileNavigator.add(new FileData("file", (byte) 44, "path/to/file"));
        fileNavigator.add(new FileData("file", (byte) 32, "path2/to/file"));
        fileNavigator.add(new FileData("file", (byte) 12, "path3/to/file"));
        fileNavigator.add(new FileData("file66", (byte) 4, "path3/to/file"));
        fileNavigator.add(new FileData("file", (byte) 22, "path/to/file"));
        fileNavigator.add(new FileData("file", (byte) 2, "path/to/file"), "path/to/file2");
        fileNavigator.add(new FileData("file5", (byte) 3, "path/to/file2"), "path/to/file2");
        fileNavigator.getFiles().forEach((key, value) -> {
            System.out.println("key : " + key);
            value.forEach(el -> {
                System.out.println("value : " + el.name() + " " + el.path() + " " + el.size());
            });
        });
        System.out.println("filterBySize");
        fileNavigator.filterBySize(33).forEach((key) -> {
            System.out.println("key : " + key.name() + " " + key.size() + " ");
        });
        System.out.println("find :");
        fileNavigator.find("path/to/file").forEach((key) -> {
            System.out.println("key : " + key.name() + " " + key.size() + " ");
        });
        fileNavigator.remove("path/to/file");

        System.out.println("after delete: ");
        fileNavigator.getFiles().forEach((key, value) -> {
            System.out.println("key : " + key);
            value.forEach(el -> {
                System.out.println("value : " + el.name() + " " + el.path() + " " + el.size());
            });
        });
        System.out.println("SORT");
        fileNavigator.sortFiles().forEach((key) -> {
            System.out.println("key : " + key.name() + " " + key.size() + " ");
        });
    }
}