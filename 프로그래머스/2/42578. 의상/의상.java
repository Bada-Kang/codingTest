import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        for(String[] clo : clothes) {
            if (hash.containsKey(clo[1])) {
                hash.put(clo[1], hash.get(clo[1])+1);
            } else {
                hash.put(clo[1], 1);
            }
        }
        //새로운 배열에 저장
        int[] arr = new int[hash.size()];
        int i = 0;
        for (String key : hash.keySet()) {
		    arr[i++] = hash.get(key);
        }
        
        //경우의 수 계산
        //(jacket종류개수 +1 ) * (hat 종류개수 +1) * (pants 종류개수 +1 ) -1
        if (arr.length == 1) {
            return arr[0];
        }
        for (int k = 0; k < arr.length; k++) {
            answer *= arr[k]+1;
        }


        
        return answer - 1;
    }
    

}