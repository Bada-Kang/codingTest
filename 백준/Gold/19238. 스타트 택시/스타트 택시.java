import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int Fuel;
    static int[][] passengers_maps;

    //고객 리스트를 해시맵으로 관리
    static HashMap<Integer, Passenger> passengers = new HashMap<>();

    //성공한 고객 수
    static int success = 0; //성공한 승객 수



    //방향 정의 -> 상좌우하 순서로 탐색해야함
    static int[] drow = {-1, 0, 0, 1};
    static int[] dcol = {0, -1, 1, 0};

    public static class Passenger {
        int row, col;
        int goal_row, goal_col;
        public Passenger(int row, int col, int goal_row, int goal_col) {
            this.row = row;
            this.col = col;
            this.goal_row = goal_row;
            this.goal_col = goal_col;
        }
    }

    public static class Node {
        int row, col, step;
        public Node(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Fuel = sc.nextInt();
        passengers_maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                passengers_maps[i][j] = sc.nextInt();
            }
        }

        //운전자의 초기 위치
        int row = sc.nextInt();
        int col = sc.nextInt();

        row--;
        col--;

        for (int i = 2; i < M + 2; i++) { //고객번호는 2부터 관리 (1이 벽이므로)
            int r = sc.nextInt();
            int c = sc.nextInt();
            int g_r = sc.nextInt();
            int g_c = sc.nextInt();

            passengers.put(i, new Passenger(r-1, c-1, g_r-1, g_c-1));
            passengers_maps[r-1][c-1] = i; //목적지 말고 승객 위치만 승객맵에 기록
        }

        //success : 성공한 승객 수

        boolean isPossible = true;

        while (Fuel > 0 && success < M) { //연료가 바닥나면 종료, 승객을 전부 태우면 종료
            int[] resultLoc = gotoPassenger(row, col); //최종 현재 위치 반환

            //여기서 int[] 배열에 -1이 있는지 확인하기
            if (resultLoc[0] == -1) {
                System.out.println(-1);
                isPossible = false;
                break;
            } else {
                row = resultLoc[0]; //운전자의 위치 변경
                col = resultLoc[1];
            }
        }
        if (isPossible) System.out.println(Fuel);


    }

    //1. 택시의 현재 위치에서 가장 가까운 승객까지 탐색(행번호가 작고 열번호가 작도록) -> 상좌우하
    public static int[] gotoPassenger(int row, int col) {
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, 0));
        visited[row][col] = true;

        int minDist = -1; // 가장 가까운 승객 거리
        List<int[]> candidates = new ArrayList<>(); // {row, col, passengerNum}

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_row = node.row;
            int cur_col = node.col;
            int cur_step = node.step;

            // 이미 더 먼 거리라면 탐색 중단
            if (minDist != -1 && cur_step > minDist) break;

            // 승객을 찾은 경우
            if (passengers_maps[cur_row][cur_col] >= 2) {
                if (minDist == -1) minDist = cur_step; // 첫 발견이면 거리 확정
                candidates.add(new int[]{cur_row, cur_col, passengers_maps[cur_row][cur_col]});
            }

            // 4방향 탐색 (상좌우하)
            for (int i = 0; i < 4; i++) {
                int new_row = cur_row + drow[i];
                int new_col = cur_col + dcol[i];

                if (new_row < 0 || new_col < 0 || new_row >= N || new_col >= N) continue;
                if (passengers_maps[new_row][new_col] == 1 || visited[new_row][new_col]) continue;

                visited[new_row][new_col] = true;
                queue.add(new Node(new_row, new_col, cur_step + 1));
            }
        }

        // 승객을 못 찾은 경우
        if (candidates.isEmpty()) return new int[]{-1, -1};

        // 같은 거리 승객 중 행/열 오름차순 정렬
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // row
            return a[1] - b[1];                   // col
        });

        int final_row = candidates.get(0)[0];
        int final_col = candidates.get(0)[1];
        int passengerNum = candidates.get(0)[2];

        // 연료 확인
        if (Fuel < minDist) return new int[]{-1, -1};
        Fuel -= minDist;

        // 승객 제거
        passengers_maps[final_row][final_col] = 0;
        Passenger p = passengers.remove(passengerNum);

        // 목적지로 이동
        return gotoDestination(final_row, final_col, p);
    }


    //2. 목적지로 이동 & 연료 계산 & 연료 충전
    public static int[] gotoDestination(int row, int col, Passenger passenger) {
        //목적지 위치 저장
        int goal_row = passenger.goal_row;
        int goal_col = passenger.goal_col;

        //현재 위치 노드 만들기
        Node startNode = new Node(row, col, 0);

        //방문 배열
        boolean[][] visited = new boolean[N][N];

        //BFS 시작
        visited[row][col] = true;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(startNode);

        int totalStep = -1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_row = node.row;
            int cur_col = node.col;
            int cur_step = node.step;

            if (cur_row == goal_row && cur_col == goal_col) {
                //목적지 찾음 처리
                totalStep = cur_step;
                break;
            }

            for (int i = 0; i < drow.length; i++) {
                int new_row = cur_row + drow[i];
                int new_col = cur_col + dcol[i];

                if (new_row < 0 || new_col < 0 || new_row >= N || new_col >= N) continue;
                if (passengers_maps[new_row][new_col] == 1 || visited[new_row][new_col]) continue;

                //이동가능시 방문 처리
                visited[new_row][new_col] = true;
                queue.add(new Node(new_row, new_col, cur_step+1));
            }
        }

        //System.out.println(totalStep);

        if (totalStep == -1) return new int[]{-1, -1};
        
        
        if (Fuel - totalStep >= 0) {
            Fuel -= totalStep; //해당 승객에게 가기 위해 연료 소모
            Fuel += totalStep * 2;
        } else { //해당 승객까지 갈 수 없음
            return new int[] {-1, -1};
        }

        //success +1 해주기 (승객에게 도달 완료)
        success++;

        return new int[] {goal_row, goal_col};
    }


}
