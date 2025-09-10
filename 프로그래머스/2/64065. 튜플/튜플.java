import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(0, s.length()-2).replace("{", "");
        String[] arr = s.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        //각 원소를 순회하면서 이전 원소와 차이나는 부분을 구함
        for (int i = 0; i < arr.length; i++) {
            String[] numbers = arr[i].split(",");
            for (String number : numbers) {
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        return answer;
    }
}