import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        HashSet<String> set = new HashSet<>();
        
        for (String gem : gems) {
            set.add(gem);
        }
        
        int size = set.size();
        
        HashMap<String, Integer> hash = new HashMap<>();
        
        int left = 0;
        int bestL = 0, bestR = gems.length - 1;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < gems.length; right++) {
            hash.put(gems[right], hash.getOrDefault(gems[right], 0) + 1);
            
            while (hash.size() == size) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    bestL = left;
                    bestR = right;
                }
                
                String g = gems[left];
                hash.put(g, hash.get(g) - 1);
                if (hash.get(g) == 0) {
                    hash.remove(g);
                }
                left++;
            }
        }

        
        int[] answer = new int[] {bestL+1, bestR+1};
        return answer;
    }
}