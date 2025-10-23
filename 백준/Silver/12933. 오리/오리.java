import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        // 길이가 5의 배수가 아니면 -1
        if (str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        
        char[] arr = str.toCharArray();
        boolean[] visited = new boolean[arr.length];
        String quack = "quack";
        
        int duckCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // 아직 방문하지 않은 'q'를 찾으면 새로운 오리 시작
            if (!visited[i] && arr[i] == 'q') {
                int idx = 0;  // quack의 인덱스
                
                for (int j = i; j < arr.length; j++) {
                    if (!visited[j] && arr[j] == quack.charAt(idx)) {
                        visited[j] = true;
                        idx++;
                        
                        // "quack" 한 번 완성
                        if (idx == 5) {
                            idx = 0;  // 다시 처음부터 시작 (같은 오리가 여러 번 울 수 있음)
                        }
                    }
                }
                
                // 완전한 "quack"을 최소 한 번은 완성해야 함
                if (idx != 0) {
                    System.out.println(-1);
                    return;
                }
                
                duckCount++;
            }
        }
        
        // 모든 문자가 방문되었는지 확인
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(duckCount);
    }
}