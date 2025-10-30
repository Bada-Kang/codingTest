import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        //확장자별로 저장할 map 선언
        HashMap<String, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] temp = str.split("\\.");
            map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
        }

        String[] arr = new String[map.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[idx++] = entry.getKey();
        }

        Arrays.sort(arr);

        //이제 map에서 조회해서 출력만 하면 끝
        for (String str : arr) {
            System.out.println(str + " " + map.get(str));
        }
        
    }
}