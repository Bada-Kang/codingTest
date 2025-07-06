import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
    int n = triangle.length;

    // 아래에서 위로 올라가며 합산
    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j < triangle[i].length; j++) {
            // 아래 행의 왼쪽(j)과 오른쪽(j+1) 중 큰 값을 더함
            triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }

    // 꼭대기에 최댓값이 저장되어 있음
    return triangle[0][0];
}


}