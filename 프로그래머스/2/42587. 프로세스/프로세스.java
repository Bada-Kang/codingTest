import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> p_queue = new ArrayDeque<>();
        Queue<Integer> order = new ArrayDeque<>();
        Queue<Integer> ans = new ArrayDeque<>();


        for (int i = 0; i < priorities.length; i++) {
            p_queue.add(priorities[i]);
        }

        for (int i = 0; i < priorities.length; i++) {
            order.add(i);
        }


        while (p_queue.size() > 0) {
            int maxValue = Integer.MIN_VALUE;
            for (int value : p_queue) {
                if (value >= maxValue) {
                    maxValue = value;
                }
            }
            int first = p_queue.poll();
            if (first == maxValue) {
                ans.add(order.poll());
            } else {
                p_queue.add(first);
                order.add(order.poll());
            }

        }

        // Queue를 Integer 배열로 변환
        Integer[] integerArray = ans.toArray(new Integer[0]);

        // Integer 배열을 기본형 int 배열로 변환
        int[] intArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();

        int answer = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == location) {
                answer = i;
            }

        }
        
        return answer+1;
    }
}