import java.util.*;

/*
ROR 게임은 두 팀으로 나누어 진행하며, 상대 팀 진영을 먼저 파괴 -> 따라서 상대팀 진영에 최대한 빨리 도착하기
칸의 개수의 최댓값을 return, 불가능하면 -1
*/

class Node {
    int x;
    int y;
    int count;
    
    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        //전형적인 BFS문제, DFS의 경우 스택이나 재귀를 사용하겠지만, BFS의 경우 QUEUE나 반복문 등을 사용한다.
        int answer = -1;
        
        Node node = new Node(0, 0, 1);
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        
        int count = 0;
        
        boolean[][] visited =
            new boolean[maps.length][maps[0].length];

        visited[0][0] = true;

        
        while (!queue.isEmpty()) {
            Node now = queue.poll(); //현재 노드를 꺼냄
            
            int curx = now.x;
            int cury = now.y;
            int curcount = now.count;
        
            //종료 조건 설정
            if (curx == maps[0].length-1 && cury == maps.length-1) {
                answer = curcount;
                break;
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];
                
                //지나갈 수 없는 경우
                if (nextx >= maps[0].length || nexty >= maps.length || nextx < 0 || nexty < 0) {
                    continue;
                }
                
                if (maps[nexty][nextx] == 1 && !visited[nexty][nextx]) {

                    visited[nexty][nextx] = true;

                    queue.add(new Node(nextx, nexty, curcount + 1));
                }
            }
        }
        
        
        return answer;
    }
}