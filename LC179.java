package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LC179 {
    public static void main(String[] args) {
        largestNumber(new int[] {8308,8308,830});
    }

    public static String largestNumber(int[] nums) {
        String[] sArr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Comparator<String> numComp = (s1, s2) -> (s2+s1).compareTo(s1+s2);

        String ans = Arrays.stream(sArr).sorted(numComp).collect(Collectors.joining());
        if(ans.startsWith("0"))
            return "0";

        return ans;
    }
}
