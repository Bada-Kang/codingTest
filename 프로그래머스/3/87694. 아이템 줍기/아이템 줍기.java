import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int n = 102;
        int m = 102;
        int answer = 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 0;
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        //시작
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //현재 위치를 꺼냄
            //System.out.println(cur[0] + " " + cur[1]);
            
            if (cur[0] == itemX && cur[1] == itemY) { //탈출 조건
                answer = cur[2];
                break;
            }
            
            for (int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) { //범위를 벗어날 경우
                    continue;
                }
                if (visited[newX][newY] != false) {
                    continue;
                }
                
                if (map[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY, cur[2]+1});
                    visited[newX][newY] = true;
                }
                
       
            }
        }
        
        
        return answer / 2;
    }
}