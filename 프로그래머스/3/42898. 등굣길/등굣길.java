import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        //정보를 저장할 map 선언
        int[][] map = new int[n][m];
        
        //물에 잠긴 지역을 -1로 표시
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        //오른쪽으로 쭉 가는 경우 채우기
        for (int i = 1; i < m; i++) {
            if (map[0][i] != -1) { //물 웅덩이가 아니라면
                map[0][i] = 1;
            } else { //물 웅덩이면 탈출
                break;
            }
        }
        
        //아래로 쭉 가는 경우 채우기
        for (int i = 1; i < n; i++) {
            if (map[i][0] != -1) { //물 웅덩이가 아니라면
                map[i][0] = 1;
            } else { //물 웅덩이면 탈출
                break;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //현재 위치가 웅덩이라면
                if (map[i][j] == -1) {
                    continue;
                }
                
                //왼쪽, 위 둘다 1이상일 경우
                if (map[i-1][j] >= 1 && map[i][j-1] >= 1) {
                    //둘중에 더 작은 값에 + 1해서 저장
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                }
                
                //둘다 0또는 -1인 경우
                else if (map[i-1][j] < 1 && map[i][j-1] < 1) {
                    continue;
                } 
                
                //둘중에 하나가 0또는 -1인 경우
                else {
                    //둘중에 더 큰 값에 + 1해서 저장
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]) % 1000000007;
                }
                
            }
        }
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 System.out.print(map[i][j] + " ");
//             }
            
//             System.out.println();
//         }
        
        return map[n-1][m-1];
    }
}