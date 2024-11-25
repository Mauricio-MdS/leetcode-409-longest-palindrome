import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            characterFrequency.merge(c, 1, Integer::sum);
        }

        int result = 0;
        boolean hasOddFrequency = false;

        for (int frequency : characterFrequency.values()) {
            result += frequency;

            if (frequency % 2 == 1) {
                result--;
                hasOddFrequency = true;
            }
        }

        if (hasOddFrequency) result++;

        return result;
    }
}