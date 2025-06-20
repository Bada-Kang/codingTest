import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        //앞에 추가	addFirst(e) / offerFirst(e)	덱의 앞에 삽입
        // 뒤에 추가	addLast(e) / offerLast(e)	덱의 뒤에 삽입
        // 앞에서 꺼내기	removeFirst() / pollFirst()	앞 요소 제거 후 반환
        // 뒤에서 꺼내기	removeLast() / pollLast()	뒤 요소 제거 후 반환
        // 앞 요소 조회	getFirst() / peekFirst()	제거 없이 앞 요소 조회
        // 뒤 요소 조회	getLast() / peekLast()	제거 없이 뒤 요소 조회
        // 크기 확인	size()	요소 개수 반환
        // 비었는지 확인	isEmpty()	비었는지 여부 확인
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                deque.addLast(deque.removeFirst());
            }
            
            Boolean isValid = true;
            
            Stack<Character> stack = new Stack<>();
            
            for (Character c : deque) {
                if (c.equals('(') || c.equals('[') || c.equals('{')) {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    Character temp = stack.pop();
                    switch (temp) {
                        case '(':
                            if (!c.equals(')')) {
                                isValid = false;
                            }
                            break;
                        case '[':
                            if (!c.equals(']')) {
                                isValid = false;
                            }
                            break;
                        case '{':
                            if (!c.equals('}')) {
                                isValid = false;
                            }
                            break;
                    }
                } else {
                    isValid = false;
                }
            }
            
            if (isValid && stack.isEmpty()) {
                answer+=1;
            }
            
            
        }

        
        
        return answer;
    }
}