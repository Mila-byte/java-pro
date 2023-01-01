package homework4.general_tasks;

import homework4.general_tasks.task_4.TaskFour;

import java.util.*;

public class GeneralTasks {
    public GeneralTasks() {
        testCountOccurrence();
        testToList();
        testFindUnique();
        testCalcOccurrence();
        TaskFour taskFour = new TaskFour();
    }


    public void countOccurrence(List<String> strings, String comparisonString) {
        int count = 0;
        for (String str : strings) {
            if (str.toLowerCase().equals(comparisonString.toLowerCase())) {
                count++;
            }
        }

        System.out.println("string " + comparisonString + " occurs " + count);
    }

    public List toList(Integer[] numbers) {
        return Arrays.asList(numbers);
    }

    public List findUnique(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        return uniqueNumbers;
    }

    public void calcOccurrence(List<String> strings) {
        Map<String, Integer> occurrencesInfo = new HashMap<>();
        int defaultValue = 1;
        for (String string : strings) {
            String key = string.toLowerCase();
            Integer value = occurrencesInfo.containsKey(key) ? occurrencesInfo.get(key) + 1 : defaultValue;
            occurrencesInfo.put(key, value);
        }
        occurrencesInfo.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    private void testCountOccurrence() {
        List<String> strings = new ArrayList<>();
        strings.add("sss");
        strings.add("aaa");
        strings.add("ssуs");
        strings.add("ada");
        strings.add("sss");
        countOccurrence(strings, "sss");
    }

    private void testToList() {
        Integer[] numbers = {1, 2, 3};
        List<Integer> newNumbersList = toList(numbers);
        System.out.println("new number list " + newNumbersList);
    }

    private void testFindUnique() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(133);
        numbers.add(3);
        numbers.add(2);
        numbers.add(2);
        numbers.add(10);
        numbers.add(1);
        numbers.add(133);
        System.out.println("unique values " + findUnique(numbers));
    }

    private void testCalcOccurrence() {
        List<String> strings = new ArrayList<>();
        strings.add("sss");
        strings.add("aaa");
        strings.add("ssуs");
        strings.add("ada");
        strings.add("SSS");
        calcOccurrence(strings);
    }
}
