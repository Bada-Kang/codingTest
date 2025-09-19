import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //기본 오름차순 큐
        
        for (String str : operations) {
            String[] cur_arr = str.split(" ");
            if (cur_arr[0].equals("I")) { //주어진 숫자 삽입
                pq.add(Integer.parseInt(cur_arr[1]));
            } else {
                if (pq.size() == 0) {
                    continue;
                }
                if (cur_arr[1].equals("1")) { //최댓값 삭제
                    //내림차순 큐로 변경
                    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
                    pq2.addAll(pq);
                    pq = pq2;
                    pq.poll();

                    //다시 원래대로
                    PriorityQueue<Integer> pq3 = new PriorityQueue<>();
                    pq3.addAll(pq);
                    pq = pq3;
                } else { //최솟값 삭제
                    pq.poll();
                }
            }
        }
        //System.out.println(pq);
        
        if (pq.size() == 0) {
            answer[0] = 0; 
            answer[1] = 0;
        } else {
            int num = pq.poll();
            answer[1] = num;
            while (!pq.isEmpty()) {
                num = pq.poll();
            }
            answer[0] = num;
        }
    
        
        
        
        return answer;
    }
}