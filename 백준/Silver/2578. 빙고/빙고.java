import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[5][5];
    static int[][] orders = new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) {

        int seq = 0; //몇 번째 인지

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                orders[i][j] = sc.nextInt();
            }
        }

        //사회자가 부르는거 하나씩 채워나가기
        for (int[] order : orders) {
            for (int target : order) {
                visit(target); //방문하기
                seq++; //몇번째인지 카운트 올리기
                if (check() >= 3) break;

            }
            if (check() >= 3) break;
        }
        System.out.println(seq);


    }

    public static void visit(int target) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == target) {
                    visited[i][j] = true; //방문체크
                }
            }
        }
    }

    //빙고의 개수를 확인하는 함수
    public static int check() {
        int count = 0;

        //1. 가로 검사
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    flag = false;
                }
            }
            if (flag) count++;
        }

        //2. 세로 검사
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[j][i]) {
                    flag = false;
                }
            }
            if (flag) count++;
        }

        //3. 대각선(좌) 검사
        boolean flag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) {
                flag2 = false;
            }
        }
        if (flag2) count++;

        //4. 대각선(우) 검사
        flag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][4-i]) {
                flag2 = false;
            }
        }
        if (flag2) count++;


        return count;
    }
}
