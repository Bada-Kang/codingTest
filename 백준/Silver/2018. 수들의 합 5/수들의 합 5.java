import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
        //이 N을 몇개이 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int count = 0;
        int s = 0;
        int e = 0;


        //자연수 n까지의 누적합 구하기
        for (int i = 1; i <= n; i++) {
            arr[i] = i + arr[i-1];
        }

        while (s < n+1 && e < n+1) {
            if (arr[e]-arr[s] == n) {
                count++;
                e++;
            } else if (arr[e]-arr[s] < n) {
                e++;
            } else {
                s++;
            }
        }

        System.out.println(count);


    }
}