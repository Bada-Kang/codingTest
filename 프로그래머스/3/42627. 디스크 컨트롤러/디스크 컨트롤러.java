import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 도착시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 실행시간 짧은 순
        
        int time = 0, idx = 0, total = 0, count = jobs.length;
        
        while (idx < count || !pq.isEmpty()) {
            while (idx < count && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]); // 현재 시간까지 도착한 작업들 큐에 넣기
            }
            
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time += cur[1];
                total += (time - cur[0]); // turnaround
            } else {
                time = jobs[idx][0]; // 다음 작업 도착까지 점프
            }
        }
        
        return total / count;
    }
}
