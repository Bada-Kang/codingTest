import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] maps;
    static ArrayList<Pair> availableLoc = new ArrayList<>();
    static ArrayList<Pair> virusLoc = new ArrayList<>();

    //정답
    static int result = 0;


    //방향 정의
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    public static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    //벽 세우기 가능한 공간 리스트에 추가
                    availableLoc.add(new Pair(i, j));
                }
                if (maps[i][j] == 2) {
                    //바이러스 위치 저장
                    virusLoc.add(new Pair(i, j));
                }
            }
        }



        /*
        1. 0인 곳 중 3군데를 완전 탐색으로 모두 도전
            - 이 로직이 핵심 (N^3)
            - 후보 좌표를 리스트에 담음 (클래스에 정의)
            - 3중 for 문으로 탐색 */
        findWall();


        System.out.println(result);
    }

    public static void findWall() {
        for (int i = 0; i < availableLoc.size(); i++) {
            for (int j = i+1; j < availableLoc.size(); j++) {
                for (int k = j+1; k < availableLoc.size(); k++) {

                    Pair firstWall = availableLoc.get(i);
                    Pair secondWall = availableLoc.get(j);
                    Pair thirdWall = availableLoc.get(k);

                    int[][] newMaps = new int[N][M];
                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < M; y++) {
                            newMaps[x][y] = maps[x][y];
                        }
                    }
                    newMaps[firstWall.row][firstWall.col] = 1;
                    newMaps[secondWall.row][secondWall.col] = 1;
                    newMaps[thirdWall.row][thirdWall.col] = 1;

                    // 2. BFS로 바이러스를 퍼뜨림
                    expandVirus(newMaps);
                }
            }
        }
    }

    public static void expandVirus(int[][] newMaps) {
        for (Pair pair : virusLoc) {
            boolean visited[][] = new boolean[N][M];

            //첫번째 바이러스부터 확산 시작
            ArrayDeque<Pair> queue = new ArrayDeque<>();
            visited[pair.row][pair.col] = true;
            queue.add(pair);

            while(!queue.isEmpty()) {
                Pair virus = queue.poll();
                int virusRow = virus.row;
                int virusCol = virus.col;

                for (int i = 0; i < drow.length; i++) {
                    int newRow = virusRow + drow[i];
                    int newCol = virusCol + dcol[i];

                    if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= M) {
                        continue;
                    }

                    if (newMaps[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        newMaps[newRow][newCol] = 2; //바이러스 확산
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }

        }

        //바이러스 확산 완료시 안전영역 계산
        calSafetyZone(newMaps);
    }

    public static void calSafetyZone(int[][] newMaps) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMaps[i][j] == 0) {
                    count++;
                }
            }
        }
        //안전영역 수 최댓값 구하기
        if (count > result) {
            result = count;
        }
    }


}
