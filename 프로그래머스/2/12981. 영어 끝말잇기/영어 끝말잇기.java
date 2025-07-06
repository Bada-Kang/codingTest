import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set =  new HashSet<>();
        int[] answer = new int[2];
        
        int count  = 0;
        String lastWord = "";
        for (String str : words) {
            count += 1;
            if (count > 1 && !(lastWord.equals(str.substring(0, 1)))) {
                System.out.println(count);
                int temp = count % n;
                answer[0] = temp==0 ? n : temp;
                answer[1] = (int)Math.ceil((double)count / n);
                break;
            }
            else if (!set.contains(str)) {
                set.add(str);
                lastWord = str.substring(str.length() - 1);
            } else {
                int temp = count % n;
                answer[0] = temp==0 ? n : temp;
                answer[1] = (int)Math.ceil((double)count / n);
                break;
            }
        }


        return answer;
    }
}