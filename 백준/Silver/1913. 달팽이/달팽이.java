import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();

        int[][] arr = new int[n][n];

        int direction = 0;
        int row = 0;
        int col = 0;
        int[] loc = new int[2];

        for (int i = n * n; i > 0; i--) {
            if (i == num) {
                loc[0] = row;
                loc[1] = col;
            }
            arr[row][col] = i;

            if (direction == 0) { // 아래
                // 다음 이동 위치 미리 확인
                int nextRow = row + 1;
                if (nextRow >= n || arr[nextRow][col] != 0) {
                    direction = 1; // 오른쪽으로 전환
                    col++;
                } else {
                    row++;
                }

            } else if (direction == 1) { // 오른쪽
                int nextCol = col + 1;
                if (nextCol >= n || arr[row][nextCol] != 0) {
                    direction = 2; // 위로 전환
                    row--;
                } else {
                    col++;
                }

            } else if (direction == 2) { // 위
                int nextRow = row - 1;
                if (nextRow < 0 || arr[nextRow][col] != 0) {
                    direction = 3; // 왼쪽으로 전환
                    col--;
                } else {
                    row--;
                }

            } else { // 왼쪽
                int nextCol = col - 1;
                if (nextCol < 0 || arr[row][nextCol] != 0) {
                    direction = 0; // 다시 아래로 전환
                    row++;
                } else {
                    col--;
                }
            }
        }
        for (int[] array : arr) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println(loc[0]+1 + " " + (loc[1]+1));
    }
}
