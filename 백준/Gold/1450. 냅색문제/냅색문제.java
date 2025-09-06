import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        // 가중치가 여러 줄로 주어져도 안전하게 읽기
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (idx < N) {
            while (st.hasMoreTokens() && idx < N) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            if (idx < N) st = new StringTokenizer(br.readLine());
        }

        int mid = N / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, N);

        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();

        // 부분합 생성 (합이 C를 넘으면 더 깊이 안 내려감 = 가지치기)
        genSums(left, 0, 0, L);
        genSums(right, 0, 0, R);

        Collections.sort(R); // 오른쪽만 정렬 → upperBound로 개수 셈

        long answer = 0;
        for (int w : L) {
            if (w > C) continue;
            int remain = C - w;
            // R에서 remain 이하의 원소 개수
            int cnt = upperBound(R, remain);
            answer += cnt;
        }

        System.out.println(answer); // 공집합 포함
    }

    // 부분집합 합 생성 (합이 C 넘으면 더 진행 X)
    static void genSums(int[] a, int i, int sum, ArrayList<Integer> out) {
        if (sum > C) return;      // 가지치기: 더 더해도 의미 없음
        if (i == a.length) {
            out.add(sum);
            return;
        }
        genSums(a, i + 1, sum, out);           // 안 넣기
        genSums(a, i + 1, sum + a[i], out);    // 넣기
    }

    // upperBound: list에서 target 이하인 원소 개수
    static int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l; // <= target 개수
    }
}
