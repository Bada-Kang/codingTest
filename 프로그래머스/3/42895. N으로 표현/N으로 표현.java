import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[k] = N을 k번 사용해서 만들 수 있는 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // 1) N을 k번 이어붙인 수를 dp[k]에 넣기
        int concat = 0;
        for (int k = 1; k <= 8; k++) {
            concat = concat * 10 + N; 
            dp.get(k).add(concat);
        }
        
        // 2) 점화식: dp[i]와 dp[k-i] 조합
        for (int k = 1; k <= 8; k++) {
            for (int i = 1; i < k; i++) {
                for (int a : dp.get(i)) {
                    for (int b : dp.get(k - i)) {
                        dp.get(k).add(a + b);
                        dp.get(k).add(a - b);
                        dp.get(k).add(a * b);
                        if (b != 0) dp.get(k).add(a / b);
                    }
                }
            }
            
            // 종료 조건
            if (dp.get(k).contains(number)) {
                return k;
            }
        }
        
        // 8번까지 못 만들면 -1
        return -1;
    }
}
