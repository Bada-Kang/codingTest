import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cur_h = sc.nextInt();
        int cur_m = sc.nextInt();
        int need_m = sc.nextInt();
        
        cur_m += need_m;

        while (cur_m >= 60) {
            cur_m -= 60;
            cur_h += 1;
        }
        if (cur_h >= 24) {
            cur_h -= 24;
        }
        System.out.println(cur_h + " " + cur_m);
        
        sc.close();
    }
}