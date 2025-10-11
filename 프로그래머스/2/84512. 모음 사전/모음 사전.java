class Solution {
    private int count = 0;      // 현재까지 생성한 단어 개수
    private String target;       // 찾아야 할 단어
    private boolean found = false; // 단어를 찾았는지 여부
    
    public int solution(String word) {
        target = word;
        dfs("");  // 빈 문자열부터 시작
        return count;
    }
    
    private void dfs(String current) {
        // 이미 찾았으면 더 이상 탐색 안 함
        if (found) return;
        
        // 목표 단어를 찾으면 종료
        if (current.equals(target)) {
            found = true;
            return;
        }
        
        // 길이가 5면 더 이상 추가 불가
        if (current.length() == 5) return;
        
        // A, E, I, O, U 순서로 추가하며 탐색
        String vowels = "AEIOU";
        for (int i = 0; i < 5; i++) {
            count++;  // 단어 하나 생성
            dfs(current + vowels.charAt(i));  // 재귀 호출
            if (found) return;  // 찾았으면 즉시 종료
        }
    }
}