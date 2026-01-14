import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (map.containsKey(from)) { //키를 가지고 있는 경우
                map.get(from).add(to);
            } else { //키가 없는 경우
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                map.put(from, pq);
            }
        }
        
        String to = "ICN"; //초기 시작 경로
        ArrayList<String> result = new ArrayList<>();

        Stack<String> stack = new Stack<>();
        stack.push(to);
        
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            PriorityQueue<String> pq = map.get(cur);

            // 더 갈 곳이 있으면 계속 내려감 (티켓 사용 = poll)
            if (pq != null && !pq.isEmpty()) {
                stack.push(pq.poll());
            } else {
                // 막히면 route에 확정(뒤에서부터 쌓임)
                result.add(stack.pop());
            }
        }

        
        
        String[] answer = new String[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(answer.length - 1 - i);
        }

        
        return answer;
    }
    
    public void dfs(HashMap<String, PriorityQueue<String>> map) {
        
    }
}