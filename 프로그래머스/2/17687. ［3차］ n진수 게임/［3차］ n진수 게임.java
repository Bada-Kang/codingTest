import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb1 = new StringBuilder(); //전체 저장
        StringBuilder sb2 = new StringBuilder(); //정답 반환용, 튜브의 역할
        
        //인덱스가 t*m이 넘어갈 때 까지 반복해서 전체 게임을 담기
        int start = 0;
        while (sb1.length() < t*m) {
            sb1.append(Integer.toString(start++, n).toUpperCase());
        }
        //튜브가 말해야 하는것만 담기
        for (int i = 0; i < t; i++) {
            int idx = i*m + (p-1);
            sb2.append(sb1.charAt(idx));
        }
        

        return sb2.toString();
    }
}