import java.util.*;
import java.util.*;

class Solution {
    class Node {
        int dest, cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        // 인접리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // fares 정보를 인접 리스트로 저장
        for (int[] edge : fares) {
            adjList[edge[0] - 1].add(new Node(edge[1] - 1, edge[2]));
            adjList[edge[1] - 1].add(new Node(edge[0] - 1, edge[2]));
        }

        // 세 번의 Dijkstra를 실행하여 각각 s -> 모든 노드, a -> 모든 노드, b -> 모든 노드의 최단거리를 구함
        int[] distFromS = dijkstra(s - 1, n, adjList);
        int[] distFromA = dijkstra(a - 1, n, adjList);
        int[] distFromB = dijkstra(b - 1, n, adjList);

        // 모든 노드를 중간점으로 고려하여 최소 비용을 계산
        for (int i = 0; i < n; i++) {
            if (distFromS[i] != Integer.MAX_VALUE && distFromA[i] != Integer.MAX_VALUE && distFromB[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
            }
        }

        return answer;
    }

    private int[] dijkstra(int start, int n, ArrayList<Node>[] adjList) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }
}
