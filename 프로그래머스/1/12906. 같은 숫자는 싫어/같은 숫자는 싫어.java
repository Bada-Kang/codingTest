import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = stack.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}