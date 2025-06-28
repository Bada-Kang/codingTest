import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int h;
        if (n % w == 0) {
            h = (int)n / w;
        } else {
            h = ((int)n / w) + 1;
        }
        
        int box_col = 0;
        int box_row = 0;
        
        int[][] location = new int[h][w];
        for (int i = 0; i < n; i++) {
            int col = h - 1 - (int)(i / w) ;
            int row = i % w;
            // System.out.println("col: " + col + ", row: " + row);
            if (h % 2 == 0) {
                if (col % 2 == 1) {
                    location[col][row] = i+1;
                    if (i+1 == num) {
                        box_col = col;
                        box_row = row;
                    }
                } else {
                    location[col][w-1-row] = i+1;
                    if (i+1 == num) {
                        box_col = col;
                        box_row = w-1-row;
                    }
                }
            } else {
                if (col % 2 == 0) {
                    location[col][row] = i+1;
                    if (i+1 == num) {
                        box_col = col;
                        box_row = row;
                    }
                } else {
                    location[col][w-1-row] = i+1;
                    if (i+1 == num) {
                        box_col = col;
                        box_row = w-1-row;
                    }
                }
            }
        
            
        }
        
        // for (int[] now : location) {
        //     System.out.println(Arrays.toString(now));
        // }
        
        // System.out.println(box_col);
        // System.out.println(box_row);
        int answer = 0;
        for (int i = 0; i <= box_col; i++) {
            if (location[i][box_row] != 0) answer++;
        }
        

        return answer;
    }
}