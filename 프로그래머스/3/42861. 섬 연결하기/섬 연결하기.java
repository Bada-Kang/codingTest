//n개의 섬 사이에 다리를 연결하는 비용이 주어짐
//최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
import java.util.*;
class Solution {
    
    class UF {
        int[] parent;
        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; //초기화
            }
        }
        
        int find(int n) {
            if (parent[n] == n) return n;
            return parent[n] = find(parent[n]);
        }
        
        //b를 a에 연결
         void union(int a, int b) {
            parent[find(b)] = find(a);
        }
        
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0; //비용
        
        UF uf = new UF(n); //유니온파인드 클래스
           
        //가장 싼 다리부터 연결하기 위해 정렬
        Arrays.sort(costs, (o1, o2) -> {
            if (o1[2] == o2[2]) { return Integer.compare(o1[0], o2[0]); }
            return Integer.compare(o1[2], o2[2]);
        });
        
        for (int[] cost : costs) {
            //연결 여부 확인
            if (uf.find(cost[0]) == uf.find(cost[1])) { //연결이 되어있다면
                continue;
            } else {
                uf.union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        

        return answer;
    }
}