import java.util.*;

class Solution {
    class Location {
        int row;
        int col;
        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    String[][] map;
    boolean[][] visited;
    ArrayList<Integer> answer = new ArrayList<>();
    public int[] solution(String[] maps) {
        //배열 초기화
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }

        boolean hasX = false;
        for (int row = 0; row<maps.length; row++) {
            for (int col = 0; col<maps[0].length(); col++) {
                if (!map[row][col].equals("X")) {
                    hasX = true;
                    bfs(row, col);
                }
            }
        }
        
        if (!hasX) return new int[] {-1};
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void bfs(int row, int col) {
        if (visited[row][col]) return;
        int sum = 0;
        
        Queue<Location> queue = new LinkedList<>();
            
        visited[row][col] = true;
        sum += Integer.parseInt(map[row][col]);
        queue.offer(new Location(row, col));
        
        
        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            int r = loc.row;
            int c = loc.col;
            if (r+1 < map.length && !visited[r+1][c] && !map[r+1][c].equals("X")) { //오른쪽으로 이동
                visited[r+1][c] = true;
                sum += Integer.parseInt(map[r+1][c]);
                queue.offer(new Location(r+1, c));
                //System.out.println((r+1) + " " + c);
            }
            if (r-1 >= 0 && !visited[r-1][c] && !map[r-1][c].equals("X")) { //왼쪽으로 이동
                visited[r-1][c] = true;
                sum += Integer.parseInt(map[r-1][c]);
                queue.offer(new Location((r-1), c));
                //System.out.println((r-1) + " " + c);
            }
            if (c-1 >= 0 && !visited[r][c-1] && !map[r][c-1].equals("X")) { //위쪽으로 이동
                visited[r][c-1] = true;
                sum += Integer.parseInt(map[r][c-1]);
                queue.offer(new Location(r, c-1));
                //System.out.println(r + " " + (c-1));
            }
            if (c+1 < map[0].length && !visited[r][c+1] && !map[r][c+1].equals("X")) { //아래쪽으로 이동
                visited[r][c+1] = true;
                sum += Integer.parseInt(map[r][c+1]);
                queue.offer(new Location(r, c+1));
                //System.out.println(r + " " + (c+1));
            }
        }
        answer.add(sum);
    }
}