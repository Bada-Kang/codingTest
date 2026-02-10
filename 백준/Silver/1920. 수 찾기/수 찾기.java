import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        //이분 탐색을 위한 정렬
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            int left = 0;
            int right = arr.length-1;

            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target[i]) {
                    flag = true;
                    break;
                }
                if (arr[mid] > target[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }


    }
}