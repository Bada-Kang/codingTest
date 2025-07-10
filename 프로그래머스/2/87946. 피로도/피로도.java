import java.util.*;

class Solution {
    
    public static int[][] list; //던전 리스트
    public static int K; //맨 처음 피로도
    public int result; //최종 결과
    
    public int solution(int k, int[][] dungeons) {
        
        list = dungeons;
        result = 0;
        
        backtracking(k, 0, new int[dungeons.length]);
        
        return result;
    }
    
    public void backtracking(int k, int sum, int[] visited) {
        if (sum > result) {
            result = sum;
        }
        
        for (int i = 0; i < list.length; i++) {
            if (k >= list[i][0] && visited[i] == 0) {
                visited[i] = 1;
                sum += 1;
                backtracking(k-list[i][1], sum, visited);
                visited[i] = 0; //원래대로 돌려놓아야 함
                sum -= 1; //이것도 원래대로
            }
        }

    }
    
    
    
}