/*
기능개발: 각 기능은 진도가 100%일 때 서비스에 반영할 수 있다.
- 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있지만, 앞의 기능이 배포될 때 같이 배포된다.
- 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열과 각 작업의 개발 속도가 적힌 정수배열이 주어지면
- 각 배포마다 몇개의 기능이 배포되는지를 return한다.
*/
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 1. 각 작업별로 몇일 걸리는지 확인하는 배열을 만든다.
        int[] process = new int[progresses.length];
        
        int idx = 0;
        for (int progress : progresses) {
            process[idx] = (int) Math.ceil((double)(100 - progresses[idx]) / speeds[idx]);
            idx += 1;
        }
        
        // 2. 그 배열을 순회하며, 본인 인덱스보다 낮은 값을 가지는 값까지 계속 탐색하며 수를 더한다.
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
        int temp = process[0];
        for (int i = 1; i < process.length; i++) {
            
            if (process[i] <= temp) { // 같이 배포가 가능하면
                count += 1;
            } else { //즉시 배포
                ans.add(count);
                count = 1;
                temp = process[i];
            }
        }
        ans.add(count);
        
        
    
        int[] answer = new int[ans.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}