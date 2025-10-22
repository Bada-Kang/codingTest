import java.util.*;
class Solution {
    
    public int solution(int n, int[][] edge) {
        
        //그래프 초기화 필요
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ed : edge) {
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        
        int[] count = new int[n+1];
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        visited[1] = true;
        queue.add(new int[]{1, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count[cur[0]] = cur[1];
            
            for (int node : graph.get(cur[0])) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(new int[]{node, cur[1]+1});
                }
            }
        }
        
        Arrays.sort(count);
        
        int max = count[n];
        int answer = 0;
        
        for (int i = n; i >= 0; i--) {
            if (count[i] == max) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}