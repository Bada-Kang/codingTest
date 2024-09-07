import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String str : completion) {
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }

        String answer = "";
        for (String str : participant) {
            if (hash.getOrDefault(str, 0) == 0) {
                answer = str;
            }
            hash.put(str, hash.getOrDefault(str, 0) - 1);
        }
        return answer;
    }
}