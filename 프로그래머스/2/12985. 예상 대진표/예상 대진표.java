import java.util.*;
/*게임대회 개최, N명이 참가하고 토너먼트 형식
N명이 참가자는 각각 1번부터 N번을 차례대로 배정받음
1<->2, N-1<->N ...
각 게임에서 이긴 사람은 다음 라운드에 진출 & 1, ... N/2번을 배정
*/
// ex) 1<->2, 3<->A, 5<->6, B<->8

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        if (a%2 != 0) a+=1;
        if (b%2 != 0) b+=1;
        
        if (a == b) {
            return answer;
        }
        
        while (Math.abs(a-b) > 1) {
            if (a%2 != 0) a+=1;
            if (b%2 != 0) b+=1;
            a /= 2;
            b /= 2;
            answer++;
        }
        
        while (Math.max(a, b) % 2 != 0) {
            if (a%2 != 0) a+=1;
            if (b%2 != 0) b+=1;
            a /= 2;
            b /= 2;
            answer++;
        }
        

        return answer;
    }
}