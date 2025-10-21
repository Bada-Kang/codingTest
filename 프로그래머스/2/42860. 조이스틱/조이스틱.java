import java.util.*;
class Solution {
    int minAnswer = Integer.MAX_VALUE;
    
    public int solution(String name) {
        String[] arr = name.split("");
        int n = arr.length;
        
        //visited 배열을 만들고, A는 이미 방문했다고 표시
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("A")) {
                visited[i] = true;
            }
        }
        
        // 모든 경로 탐색 시작
        dfs(arr, visited.clone(), 0, 0, n);
        
        return minAnswer;
    }
    
    // DFS로 모든 경로 탐색
    public void dfs(String[] arr, boolean[] visited, int cur, int answer, int n) {
        //방문 처리 먼저
        visited[cur] = true;
        
        //조이스틱 조작
        char temp = arr[cur].charAt(0);
        int up = temp - 'A';
        int down = 'Z' - temp + 1;
        answer += Math.min(up, down);
        
        //종료 조건 체크
        if (check(visited)) {
            minAnswer = Math.min(minAnswer, answer);
            return;
        }
        
        // 가지치기: 이미 더 좋은 답이 있으면 중단
        if (answer >= minAnswer) {
            return;
        }
        
        //다음 위치 정하기
        int l_step = 0;
        int r_step = 0;
        int l_temp = cur;
        int r_temp = cur;
        
        //왼쪽 탐색
        for (int i = 1; i < n; i++) {
            l_temp = cur - i;
            if (l_temp < 0) l_temp = n + l_temp;
            if (visited[l_temp] == true) {
                l_step++;
            } else {
                break;
            }
        }
        
        //오른쪽 탐색
        for (int i = 1; i < n; i++) {
            r_temp = (cur + i) % n;
            if (visited[r_temp] == true) {
                r_step++;
            } else {
                break;
            }
        }
        
        // 양쪽 모두 탐색 (greedy 대신 모든 경로 시도)
        // 왼쪽으로 이동
        dfs(arr, visited.clone(), l_temp, answer + l_step + 1, n);
        // 오른쪽으로 이동
        dfs(arr, visited.clone(), r_temp, answer + r_step + 1, n);
    }
    
    public boolean check(boolean[] visited) {
        for (boolean b : visited) {
            if (b == false) {
                return false;
            }
        }
        return true;
    }
}