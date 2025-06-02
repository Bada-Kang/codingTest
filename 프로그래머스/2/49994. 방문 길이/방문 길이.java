import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        String[] arr = dirs.split("");
        
        int x = 0;
        int y = 0;
        int cur_x = 0; 
        int cur_y = 0;
        
        //중복 체크용 HashSet 선언
        HashSet<String> set = new HashSet<>();
        
        for (String str : arr) {
            if (str.equals("U")) {
                y += 1;
            } else if (str.equals("D")) {
                y -= 1;
            } else if (str.equals("L")) {
                x -= 1;
            } else if (str.equals("R")) {
                x += 1;
            }
            
            //범위를 넘어섰는지 체크
            if (x > 5) {
                x = 5;
                continue;
            } else if (x < -5) {
                x = -5;
                continue;
            } else if (y > 5) {
                y = 5;
                continue;
            } else if (y < -5) {
                y = -5;
                continue;
            }
            
            //삽입 시도 및 중복 삽입 체크
            
            boolean added1 = set.add("("+cur_x+", "+cur_y+"), ("+x+", "+y+")");
            boolean added2 = set.add("("+x+", "+y+"), ("+cur_x+", "+cur_y+")");
            
            if (!added1 && !added2) {
                System.out.println(x + " " + y + ": 삽입에 실패했습니다!");
            } else {
                System.out.println(x + " " + y + ": 삽입에 성공했습니다!");
                answer+=1;
            }
            
            cur_x = x;
            cur_y = y;
            
        }
        

        
        
        
        return answer;
    }
}