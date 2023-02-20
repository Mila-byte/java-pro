package homework8;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {
    public boolean result(int[] nums) {
        Set uniq = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != uniq.size();
    }
}
