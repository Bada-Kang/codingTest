import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //times 오름차순 정렬
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length-1] * (long)n;
        
        while (left <= right) {
            long mid = (right + left) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid/times[i];
            }
            if (sum < n) { //검사할 수 있는 사람이 대기 사람보다 작은 경우
                left = mid + 1;
            } else { //(sum >= n) : 검사할 수 있는 사람이 대기 사람보다 큰 경우
                right = mid - 1;
                answer = mid; //일단 저장
            }
        }
        
        return answer;
    }
}