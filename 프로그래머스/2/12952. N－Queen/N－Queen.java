import java.util.*;
class Solution {
    public static ArrayList<int[]> map;
    public static int answer = 0;
    public int solution(int n) {
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new int[]{0, i});
            dfs(1, n);
            map.remove(map.size() - 1);
        }
        
        return answer;
    }
    
    public void dfs(int depth, int n) {
        if (depth == n) {
            answer += 1;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            boolean flag = true;
            
            for (int[] arr : map) {
                if (arr[1] == col) {
                    flag = false;
                }
                
                if (Math.abs(depth - arr[0]) == Math.abs(col - arr[1])) {
                    flag = false;
                }
            }
            
            if (flag) {
                map.add(new int[]{depth, col});
                dfs(depth+1, n);
                map.remove(map.size() - 1);
            }

        }
    }
}