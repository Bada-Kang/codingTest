/*
자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합
원형수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇가지 인지 궁금해짐
1. 길이가 1인 부분 수열의 합 ~ 길이가 n인 부분 수열의 합
2. set으로 관리
3. 슬라이딩 윈도우
*/
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        HashSet<Integer> set = new HashSet<>();
        for (int k = 1; k <= elements.length; k++) {
            //k는 슬라이딩 윈도우의 크기
            int sum = 0;
            
            //첫 윈도우 합
            for (int i = 0; i < k; i++) {
                sum += elements[i];
            }
            
            set.add(sum);
            
            //윈도우 슬라이드
            for (int i = k; i <= elements.length+k; i++) {
                sum += elements[i%elements.length];
                sum -= elements[(i-k)%elements.length];
                set.add(sum);
            }
            
        }
        
        return set.size();
    }
}