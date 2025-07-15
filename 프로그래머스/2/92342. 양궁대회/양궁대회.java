import java.util.*;
class Solution {
    private static int max;
    private static int[] answer;
    private static int[] apeach;
    
    //주어진 조합해서 각각의 점수 계산
    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10-i) : -(10-i);
            }
        }
        return score;
    }
    
    //최대 차이와 라이언의 과녁 저장
    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            answer = ryan.clone();
        }
        
        //점수가 같으면 가장 낮은 점수를 더 많이 맞힌 경우를 찾음
        else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != ryan[i]) {
                    if (answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    
    //가능한 라이언의 과녁점수 조합의 모든 경우를 구함
    private static void backtrack(int n, int idx, int[] ryan) {
        if (n == 0) {
            calculateDiff(ryan);
            return;
        }
        
        for (int i = idx; i <= 10; i++) {
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n - cnt, i+1, ryan);
            ryan[i] = 0;
        }
        
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);

        return max == 0 ? new int[]{-1} : answer;
    }
}