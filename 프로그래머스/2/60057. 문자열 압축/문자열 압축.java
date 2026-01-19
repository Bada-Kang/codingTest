import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length() / 2;
        
        int answer = s.length();
        
        
        for (int i = 1; i <= n; i++) { //i는 단위를 의미
            ArrayList<String> arr = new ArrayList<>();
            int lastIdx = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= s.length(); j++) {
                sb.append(s.charAt(j-1));
                if (j%i == 0) {
                    arr.add(sb.toString());
                    sb.setLength(0);
                    lastIdx = j;
                }
            }
            if (s.length() - lastIdx >= 1) {
                arr.add(s.substring(lastIdx, s.length()));    
            }
            
            String preStr = arr.get(0);
            sb.setLength(0);
            int count = 1;
            for (int j = 1; j < arr.size(); j++) {
                if (preStr.equals(arr.get(j))) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(preStr);

                    preStr = arr.get(j);
                    count = 1;
                }
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(preStr);
            //System.out.println(arr);
            //System.out.println(sb.toString());
            
            if (answer > sb.toString().length()) {
                answer = sb.toString().length();
            }
            
            //
        }
        
        
        return answer;
    }
}