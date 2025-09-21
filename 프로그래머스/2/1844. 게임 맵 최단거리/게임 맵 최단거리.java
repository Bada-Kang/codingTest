import java.util.*;
class Solution {
    
    public static class Node {
        int row;
        int col;
        int price;
        
        public Node(int row, int col, int price) {
            this.row = row;
            this.col = col;
            this.price = price;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int count = Integer.MAX_VALUE;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        //BFS를 위한 Queue 선언
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        //도착 위치 미리 선언
        int finish_row = maps.length - 1;
        int finish_col = maps[0].length - 1;
        
        //BFS 탐색 시작
        visited[0][0] = 1;
        queue.add(new Node(0, 0, 1));
        
        //상하좌우 방향 정의
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_row = node.row;
            int cur_col = node.col;
            int price = node.price;
            
            //적 진영에 도착했는지 여부 확인
            if (cur_row == finish_row && cur_col == finish_col) {
                if (price < count) {
                    count = price;
                }
            }
            
            //상하좌우 탐색
            for (int i = 0; i < drow.length; i++) {
                int new_row = cur_row + drow[i];
                int new_col = cur_col + dcol[i];
                
                //탐색이 가능한지 검증
                if (new_row < 0 || new_col < 0 || new_row > finish_row || new_col > finish_col) {
                    continue; //탐색이 불가하므로 끝냄
                } else if (maps[new_row][new_col] == 1 && visited[new_row][new_col] == 0) { //탐색이 가능할 경우
                    //방문처리
                    visited[new_row][new_col] = 1;
                    queue.add(new Node(new_row, new_col, price+1));
                }
            }
        }

        count = count != Integer.MAX_VALUE ? count : -1;
        
        return count;
    }
}