import java.util.*;

class Stage {
    int N;
    double failRatio;
    
    public Stage(int N, double failRatio) {
        this.N = N;
        this.failRatio = failRatio;
    }
    
    
}

class Solution {
    public int[] solution(int N, int[] stages) {
        //1스테이지: 1/8
        //2스테이지: 3/7
        //3스테이지: 2/4
        //4스테이지: 1/2
        //5스테이지: 0
        //만약 실패율이 같다면 작은 번호의 스테이지가 먼저 오도록
        int[] answer = new int[N];
        int[] fail = new int[N];
        int[] success = new int[N];
        double[] cal = new double[N];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i]-1 < N) {
                fail[stages[i]-1]++;
            }
            
            for (int j = 0; j<stages[i]-1; j++) {
                success[j]++;
            }
        }
        System.out.println(Arrays.toString(fail));
        System.out.println(Arrays.toString(success));
        
        
        for (int i = 0; i < N; i++) {
            if (success[i] != 0) {
                cal[i] = (double)fail[i]/success[i];
            } else {
                cal[i] = fail[i];
            }
        }
        
        PriorityQueue<Stage> pq = new PriorityQueue<>((a, b) -> {
                                                      int cmp = Double.compare(b.failRatio, a.failRatio);
                                                      if (cmp == 0) {
                                                          return Integer.compare(a.N, b.N);
                                                      }
                                                      return cmp; }
                                                     );
        for (int i = 0; i < N; i++) {
            pq.add(new Stage(i+1, cal[i]));
        }
        
        
        for (int i = 0; i < N; i++) {
            answer[i] = pq.poll().N;
        }
        
        
        
        return answer;
    }
}