import java.util.*;

class Solution {
    
    public static class Node {
        int row;
        int col;
        int count;
        
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
    public int solution(String[] board) {
        int answer = -1; // 도달 불가 시 -1 리턴 (문제 조건에 맞게 수정 가능)
        
        String[][] boards = new String[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            boards[i] = board[i].split("");
        }
        
        // R, G 위치
        int r_row = 0, r_col = 0;
        int g_row = 0, g_col = 0;
        
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                if (boards[i][j].equals("R")) {
                    r_row = i;
                    r_col = j;
                } else if (boards[i][j].equals("G")) {
                    g_row = i;
                    g_col = j;
                }
            }
        }
        
        // 방향 벡터 (상, 하, 좌, 우)
        int[] d_row = {-1, 1, 0, 0};
        int[] d_col = {0, 0, -1, 1};
        
        // 방문 체크
        boolean[][] visited = new boolean[boards.length][boards[0].length];
        visited[r_row][r_col] = true;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(r_row, r_col, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_row = node.row;
            int cur_col = node.col;
            int cur_count = node.count;

            // 1. 도착 확인
            if (cur_row == g_row && cur_col == g_col) {
                return cur_count;
            }

            // 2. 4방향 이동
            for (int i = 0; i < 4; i++) {
                int next_row = cur_row;
                int next_col = cur_col;

                // 한 방향으로 끝까지 밀기
                while (true) {
                    int r2 = next_row + d_row[i];
                    int c2 = next_col + d_col[i];

                    // 범위 밖이거나 벽이면 멈춤
                    if (r2 < 0 || r2 >= boards.length || 
                        c2 < 0 || c2 >= boards[0].length || 
                        boards[r2][c2].equals("D")) {
                        break;
                    }

                    next_row = r2;
                    next_col = c2;
                }

                // 새 위치 방문 처리
                if (!visited[next_row][next_col]) {
                    visited[next_row][next_col] = true;
                    queue.add(new Node(next_row, next_col, cur_count+1));
                }
            }
        }

        return answer; // 목표에 도달하지 못했으면 -1
    }
}
