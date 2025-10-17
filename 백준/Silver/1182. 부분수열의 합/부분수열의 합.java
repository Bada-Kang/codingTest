import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int N;
    public static int S;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //부분 수열의 개수를 1~N까지
        for (int i = 1; i <= N; i++) {
            combination(0, 0, i, new int[i]);
        }

        System.out.println(count);
    }

    //조합을 뽑는 함수
    public static void combination(int start, int depth, int R, int[] new_arr) {
        if (depth >= R) {
            //여기서 합산하는 함수 호출
            count += arr_sum(new_arr);
            return;
        }

        for (int i = start; i < N; i++) {
            new_arr[depth] = arr[i];
            combination(i + 1, depth + 1, R, new_arr);
        }
    }

    public static int arr_sum(int[] new_arr) {
        int sum = 0;
        for (int i = 0; i < new_arr.length; i++) {
            sum += new_arr[i];
        }

        if (sum == S) return 1;
        return 0;
    }
}
