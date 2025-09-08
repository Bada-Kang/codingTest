import java.util.*;

class Solution {
    static int[] visited;
    static int answer;
    static int N;
    public int solution(int n, int[][] computers) {
        
        answer = 0;
        visited = new int[n];
        N = n;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {   // 아직 방문 안 한 노드라면
                dfs(computers, i);   // 그 네트워크 전체 탐색
                answer++;            // 네트워크 개수 증가
            }
        }

        return answer;
        
        
    }
    
    public void dfs(int[][] computers, int cur) {
        visited[cur] = 1;
        //System.out.println("방문: " + cur);
    
        for (int i = 0; i < N; i++) {
            if (i != cur && computers[cur][i] == 1 && visited[i] == 0) {
                dfs(computers, i);
            }
        }

    }
}