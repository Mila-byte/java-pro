package homework4.general_tasks.task_4;

public class Word {
    private String name;
    private int occurrence = 1;

    public Word(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void increaseOccurrence() {
        occurrence++;
    }
}
