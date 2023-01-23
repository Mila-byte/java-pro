package homework4.general_tasks.task_4;

import java.util.ArrayList;
import java.util.List;

public class TaskFour {

    public TaskFour() {
        List<String> strings = new ArrayList<>();
        strings.add("sss");
        strings.add("aaa");
        strings.add("ssуs");
        strings.add("ssуs");
        strings.add("ada");
        strings.add("SSS");
        strings.add("sSуS");
        System.out.println("find occurrence: ");
        findOccurrence(strings);
    }

    public void findOccurrence(List<String> strings) {
        List<Word> words = new ArrayList<>();
        for (String string : strings) {
            boolean isExistedInList = false;

            for (Word word : words) {
                if (word.getName().equals(string.toLowerCase())) {
                    word.increaseOccurrence();
                    isExistedInList = true;
                    break;
                }
            }

            if (!isExistedInList) {
                words.add(new Word(string.toLowerCase()));
            }
        }

        words.forEach((el) -> {
            System.out.println(el.getName() + ": " + el.getOccurrence());
        });

    }
}
