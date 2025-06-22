import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] terms = new int[progresses.length];
        
        for (int i = 0; i < terms.length; i++) {
            if ((100-progresses[i])%speeds[i] == 0) {
                terms[i] = (100-progresses[i])/speeds[i];
            } else {
                terms[i] = (100-progresses[i])/speeds[i] + 1;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        int count = 0;
        for (int i = 0; i < terms.length; i++) {
            if (count == 0) {
                count = 1;
            } else if (terms[idx] < terms[i]) {
                queue.add(count);
                count = 1;
                idx = i;
            } else {
                count++;
            }         
        }
        if (count != 0) {
            queue.add(count);
        }
        
        //배열로 변경
        int[] answer = new int[queue.size()];
        for (int i = 0; i<answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        
        return answer;
    }
}