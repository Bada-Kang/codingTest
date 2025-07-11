import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1; //초기 시작
        int direction = 0;
        int preX = -1;
        int preY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if (direction == 0) { //아래로
                    arr[++preX][preY] = num++;
                } else if (direction == 1){ //오른쪽으로
                    arr[preX][++preY] = num++; //preX=6, preY=5
                    //arr[n-1-j][i] = num++;
                } else { //위로
                    arr[--preX][--preY] = num++; //preX=1, preY=
                }
            }
            //방향 전환
            if (direction == 0) {
                direction = 1;
            } else if (direction == 1) {
                direction = 2;
            } else {
                direction = 0;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        for (int[] nums : arr) {
            for (int num2 : nums) {
                if (num2 != 0) {
                    answer.add(num2);
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}