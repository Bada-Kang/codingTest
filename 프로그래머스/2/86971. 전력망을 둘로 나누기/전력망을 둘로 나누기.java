import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int countNetworks(int start, int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start); //초기 원소부터 시작
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++; //노드의 개수
            
            for (int num : graph.get(node)) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        
        return count;

    }
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        

        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        //하나씩 돌아가면서 정점 삭제
        for (int[] wire : wires) {
            int first = wire[0];
            int second = wire[1];
            
            //기존 데이터 삭제
            graph.get(first).remove(Integer.valueOf(second));
            graph.get(second).remove(Integer.valueOf(first));
            
            //양쪽 개수 세기
            int count1 = countNetworks(first, n);
            int count2 = countNetworks(second, n);
            

            //차가 더 작은 값이면 저장
            int diff = Math.abs(count1 - count2);
            if (answer > diff) {
                answer = diff;
            }
            
            
            //백트래킹 - 다시 추가
            graph.get(first).add(second);
            graph.get(second).add(first);
            
        }
        
        
        
        
        
        /*
        1. 연결리스트로 전체 그래프 정보 초기화
            1. 양방향 연결이므로 양쪽으로 초기화
        2. 각 간선을 하나씩 지워보면서 개수 차이 비교해보기
            1. 간선에 포함되어있는 정점 2개를 시작 노드로 삼아 개수 세기
        3. 모든 탐색이 끝났을 때 가장 작은 answer을 return
        
        */
        return answer;
    }
}