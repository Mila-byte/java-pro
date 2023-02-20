import homework8.Duplicate;
import homework8.Palindrome;
import homework8.TwoSum;

import java.util.Arrays;

public class Main {
    private static int[] checkingInts = new int[]{1, 2, 3, 1};
    private static String checkingStr = "A man, a plan, a canal: Panama";
    private static int[] checkIntsSum = new int[]{2, 7, 11, 15};
    private static int targetSum = 9;

    public static void main(String[] args) {
        Boolean containsDuplicate = new Duplicate().result(checkingInts);
        System.out.println(containsDuplicate);
        Boolean isPalindromeStr = new Palindrome().result(checkingStr);
        System.out.println(isPalindromeStr);
        int[] indexesNumbers = new TwoSum().result(checkIntsSum, targetSum);
        System.out.println(Arrays.toString(indexesNumbers));
    }
}