import java.util.*;
import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //정렬과 투포인터 사용
        Arrays.sort(people);
        int L = 0;
        int R = people.length - 1;
        
        while (L <= R) {
            int remain = limit - people[R];
            if (people[L] <= remain) {
                L++;
                R--;
                answer++;
            } else {
                R--;
                answer++;
            }
        }
        
        
        
        System.out.println(Arrays.toString(people));
        
        return answer;
    }
}