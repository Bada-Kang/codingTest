import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] dfs_visited;
    static boolean[] bfs_visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        //방문 배열 초기화
        dfs_visited = new boolean[n+1];
        bfs_visited = new boolean[n+1];

        //그래프 초기화 (0번 - N번 정점)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to_v = Integer.parseInt(st.nextToken());
            int from_v = Integer.parseInt(st.nextToken());
            graph.get(to_v).add(from_v);
            graph.get(from_v).add(to_v);
        }

        //그래프 정렬 (0번 - N번 정점)
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> array = graph.get(i);
            Collections.sort(array);
        }

        //dfs 결과 출력
        dfs(v);


        System.out.println();

        //bfs 결과 출력
        bfs(v);
    }

    public static void dfs(int v) {
        dfs_visited[v] = true;
        System.out.print(v + " ");
        for (int next : graph.get(v)) {
            if (!dfs_visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        bfs_visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int next : graph.get(cur)) {
                if (!bfs_visited[next]) {
                    bfs_visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
