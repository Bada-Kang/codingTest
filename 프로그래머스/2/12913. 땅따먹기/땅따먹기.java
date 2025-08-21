import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int row = land.length; //3
        int col = land[0].length; //4
        
        int[][] count = new int[row+1][col+1];
        
        for (int i=1; i<=col; i++) {
            count[1][i] = land[0][i-1];
        }
        
        for (int i=2; i<=row; i++) {
            //1열에서 시작
            for (int j=1; j<=col; j++) {
                if (j != 1) {
                    count[i][j] = Math.max(count[i-1][1] + land[i-1][j-1], count[i][j]);
                }
            }
            //2열에서 시작
            for (int j=1; j<=col; j++) {
                if (j != 2) {
                    count[i][j] = Math.max(count[i-1][2] + land[i-1][j-1], count[i][j]);
                }
            }
            //3열에서 시작
            for (int j=1; j<=col; j++) {
                if (j != 3) {
                    count[i][j] = Math.max(count[i-1][3] + land[i-1][j-1], count[i][j]);
                }
            }
            //4열에서 시작
            for (int j=1; j<=col; j++) {
                if (j != 4) {
                    count[i][j] = Math.max(count[i-1][4] + land[i-1][j-1], count[i][j]);
                }
            }
        }
        
        

        

        return Arrays.stream(count[row]).max().getAsInt();
    }
}