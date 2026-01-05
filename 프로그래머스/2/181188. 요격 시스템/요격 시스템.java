import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        ArrayList<Double> arr = new ArrayList<>();
        
        for (int[] target : targets) {
            if (arr.size() == 0) {
                arr.add(target[1]-0.1);
            } else {
                Double temp = arr.get(arr.size()-1);
                if (temp < target[1] && temp > target[0]) {
                    continue;
                } else {
                    arr.add(target[1]-0.1);
                }
            }
        }
        
        
        return arr.size();
    }
}