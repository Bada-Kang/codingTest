import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tShirts = new int[6];
        tShirts[0] = sc.nextInt();
        tShirts[1] = sc.nextInt();
        tShirts[2] = sc.nextInt();
        tShirts[3] = sc.nextInt();
        tShirts[4] = sc.nextInt();
        tShirts[5] = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();

        int t_sum = 0;
        for (int i = 0; i < tShirts.length; i++) {
            while (tShirts[i] > 0) {
                t_sum += 1;
                tShirts[i] -= t;
            }
        }

        int p1 = n/p;
        int p2 = n%p;

        sc.close();

        System.out.println(t_sum);
        System.out.println(p1 + " " + p2);

    }
}