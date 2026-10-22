import java.util.*;

/*
XYZ 마트는 금액지불 시 10일동안 회원 자격 부여
회원을 대상으로 매일 한가지 제품을 할인, 하루에 하나만 구매할 수 있음

- 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에만 회원가입
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        //원하는 전체 개수
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        
        HashMap<String, Integer> countMap = new HashMap<>();
        
        int left = 0;
        int right = 9;
        
        //초기 10일에 대한 계산
        for (int i = left; i <= right; i++) {
            int count = countMap.getOrDefault(discount[i], 0);
            countMap.put(discount[i], count + 1);
        }
        
        int answer = 0;
        while (right < discount.length) {
            boolean flag = true;
            
            //오늘 날짜를 더할지 판단
            for (String key : map.keySet()) {
                if (map.get(key) > countMap.getOrDefault(key, 0)) { //사고자 하는게 더 크면
                    flag = false;
                }
            }
            
            if (flag) {
                answer += 1;
            }
        
            
            //내일로 상태 저장 - left는 1삭제, right는 1추가
            if (right+1 < discount.length) {
                String passed = discount[left];
                String next = discount[right+1];
                countMap.put(passed, countMap.get(passed) - 1);
                countMap.put(next, countMap.getOrDefault(next, 0) + 1);
            }
            left += 1;
            right += 1;
        }
        
        return answer;
    }
}