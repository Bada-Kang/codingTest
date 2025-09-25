import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] maps;

    //경우의 수 저장
    static ArrayList<int[][]> tetrominos = new ArrayList<>();

    //정답
    static int result = 0;


    //방향 정의
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};


    public static void main(String[] args) {
//        - ArrayList<int[][]> maps 를 선언하고 테트로미노 경우의 수 13개를 저장
//        - 1번 테트로미노 경우의 수 2
//        - 2번 테트로미노 경우의 수 1
//        - 3번 테트로미노 경우의 수 8
//        - 4번 테트로미노 경우의 수 4
//        - 5번 테트로미노 경우의 수 4
//        - 종이에서 반복을 5번 하며, 맵을 탐색하고 모든 합의 경우의 수를 탐색
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        //테트로미노 경우의 수 저장
        int[][] first_1 = {{1, 1, 1, 1}};
        int[][] first_2 = {{1}, {1}, {1}, {1}};
        int[][] second = {{1, 1}, {1, 1}};
        int[][] third_1 = {{1, 0}, {1, 0}, {1, 1}};
        int[][] third_2 = {{0, 1}, {0, 1}, {1, 1}};
        int[][] third_3 = {{1, 1}, {1, 0}, {1, 0}};
        int[][] third_4 = {{1, 1}, {0, 1}, {0, 1}};
        int[][] third_5 = {{1, 1, 1}, {1, 0, 0}};
        int[][] third_6 = {{1, 1, 1}, {0, 0, 1}};
        int[][] third_7 = {{1, 0, 0}, {1, 1, 1}};
        int[][] third_8 = {{0, 0, 1}, {1, 1, 1}};
        int[][] fourth_1 = {{1, 0}, {1, 1}, {0, 1}};
        int[][] fourth_2 = {{0, 1}, {1, 1}, {1, 0}};
        int[][] fourth_3 = {{0, 1, 1}, {1, 1, 0}};
        int[][] fourth_4 = {{1, 1, 0}, {0, 1, 1}};
        int[][] fifth_1 = {{1, 1, 1}, {0, 1, 0}};
        int[][] fifth_2 = {{0, 1, 0}, {1, 1, 1}};
        int[][] fifth_3 = {{1, 0}, {1, 1}, {1, 0}};
        int[][] fifth_4 = {{0, 1}, {1, 1}, {0, 1}};
        tetrominos.add(first_1);
        tetrominos.add(first_2);
        tetrominos.add(second);
        tetrominos.add(third_1);
        tetrominos.add(third_2);
        tetrominos.add(third_3);
        tetrominos.add(third_4);
        tetrominos.add(third_5);
        tetrominos.add(third_6);
        tetrominos.add(third_7);
        tetrominos.add(third_8);
        tetrominos.add(fourth_1);
        tetrominos.add(fourth_2);
        tetrominos.add(fourth_3);
        tetrominos.add(fourth_4);
        tetrominos.add(fifth_1);
        tetrominos.add(fifth_2);
        tetrominos.add(fifth_3);
        tetrominos.add(fifth_4);

        //맵을 돌며 추적..
        for (int[][] tetromino : tetrominos) {
            for (int i = 0; i <= maps.length - tetromino.length; i++){
                for (int j = 0; j <= maps[0].length - tetromino[0].length; j++){
                    int count = 0;
                    for(int k = 0 ; k < tetromino.length; k++) {
                        for (int l = 0; l < tetromino[0].length; l++) {
                            if (tetromino[k][l] == 1) {
                                count += maps[i + k][j + l];
                            }
                        }
                    }
                    if (count > result) {
                        result = count;
                    }
                }
            }
        }

        System.out.println(result);




    }


}
