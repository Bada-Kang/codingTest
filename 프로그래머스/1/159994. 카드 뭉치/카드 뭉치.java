import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Boolean isGoal = true;
        int n1 = cards1.length;
        int n2 = cards2.length;
        
        int d1 = 0; //cards1에서의 인덱스
        int d2 = 0; //cards2에서의 인덱스
        for (int i = 0; i < goal.length; i++) {
            String str = goal[i];
            if (d1 < n1 && str.equals(cards1[d1])) {
                d1 += 1;
            } else if (d2 < n2 && str.equals(cards2[d2])) {
                d2 += 1;
            } else {
                isGoal = false;
                break;
            }
        }
        
        
        
        return isGoal ? "Yes" : "No";
    }
}