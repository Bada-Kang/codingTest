import java.util.*;
class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        int[] fibonacci = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            if (i <= 1) fibonacci[i] = 1;
            else fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;
        }
        
        return fibonacci[n];
    }
    

}