import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        String[] arr = s.split("");

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(arr[i]);
        }

        System.out.println(sum);

        sc.close();
    }
}