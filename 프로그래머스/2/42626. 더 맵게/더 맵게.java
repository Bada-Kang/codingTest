import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.add(s);
        }
        int count = 0;
        while (queue.peek() < K) {
            if (queue.size() >= 2) {
                int first = queue.poll();
                int second = queue.poll();
                int mix = first + second*2;
                queue.add(mix);
                count++;
            } else {
                count = -1;
                break;
            }
        }

        if (queue.peek() < K) {
            count = -1;
        }

        return count;
    }
}