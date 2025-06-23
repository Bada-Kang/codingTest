import java.util.*;
/*일정한 금액 지불시 10일동안 회원 자격 부여
회원 대상 매일 한가지 제품 할인
해당 제품은 하루에 한개만 구매 가능
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //1일부터 5일간 각각 구매 가능한 HashMap 만들기
        for (int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            Boolean status = true;
            for (int j = 0; j < 10; j++) {
                hashMap.put(discount[i+j], hashMap.getOrDefault(discount[i+j], 0)+1);    
            }
            //System.out.println(hashMap); //예시 출력
            for (int k = 0; k < want.length; k++) {
                if (!hashMap.containsKey(want[k]) || hashMap.get(want[k]) < number[k]) {
                    status = false;
                }
            }
            
            if (status) answer++;
        }
        
        return answer;
    }
}