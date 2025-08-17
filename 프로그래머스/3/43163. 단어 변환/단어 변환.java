import java.util.*;

class Solution {
    int level = 51;
    String target;
    int n;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.n = words.length;

        boolean[] visited = new boolean[n];
        dfs(begin, words, visited, 0);

        return level == 51 ? 0 : level;
    }

    void dfs(String cur, String[] words, boolean[] visited, int step) {
        if (cur.equals(target)) {
            level = Math.min(level, step);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && isConvertable(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], words, visited, step + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 한 글자만 다른지 체크
    boolean isConvertable(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
