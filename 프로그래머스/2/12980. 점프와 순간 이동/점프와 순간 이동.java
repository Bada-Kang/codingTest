import java.util.*;

//K 칸을 앞으로 점프하거나, 현재까지 온거리 X 2 순간이동
//점프하는 것은 K만큼의 건전지 소모


public class Solution {
    public int solution(int n) {
        int ans = 0;

        
        //2로 나누어 떨어질 때까지 나누기
        while (n > 0) {
            //홀수면 짝수로 만들어주기
            if (n % 2 == 1) {
                n -= 1;
                ans += 1;
            } else {
                n = (int)n / 2; 
            }
        }

        return ans;
    }
}