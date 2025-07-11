import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : strNums) {
            sb.append(s);
        }
        
        // 가장 앞자리가 0이면 결과는 무조건 "0"
        if (strNums[0].equals("0")) return "0";
        
    
        return sb.toString();
    }
}