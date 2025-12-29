import java.util.*;
//마을의 개수 N(1<=N<=50), road의 길이는 2000이하
class Solution {
    
    public class Node implements Comparable<Node>{
        int v;
        int c;
        public Node(int v, int c) { this.v = v; this.c = c; }
        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
    
    
    public int solution(int N, int[][] road, int K) {
        //그래프 초기화
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
            graph.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
        }
        
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //다익스트라 시작
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        dist[1] = 0;
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v; //현재 노드
            int c = node.c; //현재 노드로 까지의 시간
            if (c != dist[v]) continue; //이미 최단 경로로 초기화되었는데 서로 다르면 최단이 아님. pass
            
            for (int[] arr : graph.get(v)) {
                int nv = arr[0];
                int nc = arr[1];
                int nd = dist[v]+nc;
                if (nd < dist[nv]) {
                    dist[nv] = nd;
                    pq.add(new Node(nv, nd));
                }
            }
        }
        
        int answer = 0;
        
        for (int num : dist) {
            if (num <= K) answer++;
        }
        

        return answer;
    }
}