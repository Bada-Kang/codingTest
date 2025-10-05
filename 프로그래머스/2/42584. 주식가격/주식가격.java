import java.util.*;

class Solution {
    public class Node {
        int price, index;
        public Node (int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어질 때까지 계속 pop하면서 처리
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Node n = stack.pop();
                answer[n.index] = i - n.index;
            }
            // 현재 가격은 무조건 push
            stack.push(new Node(prices[i], i));
        }

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            answer[n.index] = (prices.length - 1) - n.index;
        }
        
        return answer;
    }
}