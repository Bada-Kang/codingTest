import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //초대한 사람 이름 저장
        HashMap<String, String> referrals = new HashMap<>();
        
        //깊이 저장
        HashMap<String, Integer> depth = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            //깊이 저장
            String name = enroll[i];
            if (referral[i].equals("-")) {
                depth.put(name, 0);
            } else {
                depth.put(name, depth.get(referral[i])+1);
            }
            //이름 저장
            referrals.put(name, referral[i]);
        }
        
        //판매량 저장
        HashMap<String, Integer> income = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int total_amount = amount[i]*100;
            //1. depth.get(name)이 0이 될때까지
            while (depth.get(name) != 0) {
                if ((int)total_amount * 0.1f == 0) {
                    break;
                }
                //벌어들인 돈의 90%를 저장
                int revenue = total_amount-(int)Math.floor(total_amount * 0.1f);
                income.put(name, income.getOrDefault(name, 0) + revenue);
                //total_amount를 남은 금액으로 변경
                total_amount -= revenue;
                //name을 윗사람으로 변경
                name = referrals.get(name);
            }
            int revenue = total_amount-(int)Math.floor(total_amount * 0.1f);
            total_amount -= revenue;
            income.put(name, income.getOrDefault(name, 0) + revenue);
        }
          
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = income.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}