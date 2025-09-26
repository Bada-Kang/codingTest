import java.util.*;
class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        
        //전체 가능한 결과 저장
        ArrayList<int[]> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    for (int l = k + 1; l <= n; l++) {
                        for (int m = l + 1; m <= n; m++) {
                            int[] temp_arr = new int[] {i, j, k, l, m};
                            
                            boolean isPossible = true;
                            
                            //주어진 q 전부 순회하며 일치하는지 확인
                            for (int key = 0; key < q.length; key++) {
                                //슬라이딩 윈도우 사용
                                int count = 0;
                                int x = 0;
                                int y = 0;
                                
                                while (x < 5 && y < 5) {
                                    if (temp_arr[x] == q[key][y]) {
                                        count++;
                                        x++;
                                        y++;
                                    } else if (temp_arr[x] > q[key][y]) {
                                        y++;
                                    } else {
                                        x++;
                                    }
                                }
                                
                                if (count != ans[key]) {
                                    isPossible = false;
                                    break;
                                }
                            }
                            if (isPossible) {
                                result.add(temp_arr);
                            }
                        }
                    }
                }
            }
        }

        return result.size();
    }
}