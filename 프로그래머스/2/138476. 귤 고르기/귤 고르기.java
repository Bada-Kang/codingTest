import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        //해시맵 선언 - 빈도수 세기
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int num : tangerine) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(hash.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = k - list.get(i);
            if (temp > 0) {
                k -= list.get(i);
                answer++;
            } else {
                answer++;
                break;
            }
        }
        
        
        return answer;
    }
}