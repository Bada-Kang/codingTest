import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i==0) {
                continue;
            }
            arr[i] += arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 1) {
                System.out.println(arr[y-1]);
            } else {
                System.out.println(arr[y-1] - arr[x-2]);
            }
        }

        sc.close();
    }
}