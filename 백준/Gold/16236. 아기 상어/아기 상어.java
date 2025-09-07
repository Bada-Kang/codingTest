import java.io.*;
import java.util.*;

public class Main {

    static class Location implements Comparable<Location> {
        private int row;
        private int col;
        private int time;
        public Location(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Location other) {
            // 우선순위 1: time (가까운 칸 먼저)
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            // 우선순위 2: row (위쪽 먼저)
            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            // 우선순위 3: col (왼쪽 먼저)
            return Integer.compare(this.col, other.col);
        }
    }

    static int N; //N*N 크기
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        //상어의 초기 위치
        int cur_row = 0;
        int cur_col = 0;

        //map 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur_row = i;
                    cur_col = j;
                    map[i][j] = 0; //9였던 위치 저장만 해놓고 0으로 바꿔줌
                }
            }
        }

        //이동은 자신의 크기와 같거나, 더 작은 물고기가 있는 칸, 비어있는 칸 이동 가능
        //더 이상 먹을 수 있는 물고기가 없다면 엄마 상어에게 도움을 요청
        //거리가 같을 시 우선순위 1. 가장 위, 2. 가장 왼쪽

        int time = 0; //초
        int level = 2; //상어의 레벨
        int fish = 0; //현재 잡아먹은 물고기 수

        //방문여부
        int[][] visited = new int[N][N];

        //BFS로 경로 구하기
        PriorityQueue<Location> queue = new PriorityQueue<>();
        visited[cur_row][cur_col] = 1;

        queue.add(new Location(cur_row, cur_col, 0)); //현재 위치 넣기

        while (!queue.isEmpty()) {
            //0. 현재 위치 꺼내기
            Location cur_loc = queue.poll();
            int row = cur_loc.getRow();
            int col = cur_loc.getCol();
            int pre_time = cur_loc.getTime();

            //System.out.println("row: " + row + ", col: " + col + ", time: " + pre_time);

            //1. 먹을 수 있는지 여부 확인
            //먹을 수 있다면
            if (map[row][col] != 0 && map[row][col] < level) {
                //System.out.println("먹음! row: " + row + ", col: " + col + ", time: " + pre_time);
                fish += 1;
                map[row][col] = 0; //먹었으므로 0으로 바꿔줌
                if (pre_time > time) {
                    time = pre_time;
                }
                if (fish == level) { //레벨 만큼 먹었을 경우
                    level++;
                    fish = 0;
                }

                queue.clear();
                visited = new int[N][N];
                queue.add(new Location(row, col, pre_time));
                continue;
            }

            //2-1. 위로 이동
            if (row > 0) {
                if (map[row - 1][col] <= level && visited[row-1][col] == 0) { //이동 가능할 경우
                    visited[row - 1][col] = 1;
                    queue.add(new Location(row-1, col, pre_time+1));
                }
            }
            //2-2. 왼쪽으로 이동
            if (col > 0) {
                if (map[row][col-1] <= level && visited[row][col-1] == 0) { //이동 가능할 경우
                    visited[row][col-1] = 1;
                    queue.add(new Location(row, col-1, pre_time+1));
                }
            }
            //2-3. 아래로 이동
            if (row < N-1) {
                if (map[row+1][col] <= level && visited[row+1][col] == 0) { //이동 가능할 경우
                    visited[row+1][col] = 1;
                    queue.add(new Location(row+1, col, pre_time+1));
                }
            }
            //2-4. 오른쪽으로 이동
            if (col < N-1) {
                if (map[row][col+1] <= level && visited[row][col+1] == 0) { //이동 가능할 경우
                    visited[row][col+1] = 1;
                    queue.add(new Location(row, col+1, pre_time+1));
                }
            }


        }

        System.out.println(time);
    }
}
