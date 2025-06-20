import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                stack.push(arr[i]);
            } else if (!stack.isEmpty()){
                if (stack.peek().equals(arr[i])) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else {
                stack.push(arr[i]);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        }
        
        return answer;
    }
}