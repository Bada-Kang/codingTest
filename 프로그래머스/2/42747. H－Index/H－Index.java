import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i; // h편 이상의 논문이 남은 개수
            if (citations[i] >= h) {
                return h; // 조건을 만족하는 최대 h
            }
        }
        return 0;
    }
}