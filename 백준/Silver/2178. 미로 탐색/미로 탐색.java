import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //map 선언
        int[][] map = new int[N][M];
        //방향 정의
        int[] drow = new int[] {0, 0, 1, -1};
        int[] dcol = new int[] {1, -1, 0, 0};
        //방문 배열
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[0][0] = true; //방문 처리
        queue.add(new int[] {0, 0, 1}); //r, c, 칸 수


        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            //종료 조건
            if (cur[0] == N-1 && cur[1] == M-1) {
                answer = cur[2];
                break;
            }

            for (int i = 0; i < drow.length; i++) {
                int new_c = cur[0] + drow[i];
                int new_r = cur[1] + dcol[i];

                if (new_c < 0 || new_c >= N || new_r < 0 || new_r >= M) {
                    continue;
                }

                if (map[new_c][new_r] == 0 || visited[new_c][new_r]) {
                    continue;
                }

                //bfs
                visited[new_c][new_r] = true;
                queue.add(new int[] {new_c, new_r, cur[2]+1});
            }
        }

        System.out.println(answer);



    }
}