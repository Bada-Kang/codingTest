import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Boolean> hash = new HashMap<>();
        for (int i : nums) {
            if (!hash.containsKey(i)) {
                hash.put(i, true);
            }
        }
        return hash.size() < nums.length/2 ? hash.size() : nums.length/2;
    }
}