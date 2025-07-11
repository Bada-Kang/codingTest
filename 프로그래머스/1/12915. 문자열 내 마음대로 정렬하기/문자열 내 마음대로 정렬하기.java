import java.util.*;
class Solution {
    
    public class Word implements Comparable<Word>{
        String word;
        int n;
        
        public Word(String word, int n) {
            this.word = word;
            this.n = n;
        }
        
        public String getWord() {
            return this.word;
        }
        
        @Override
        public int compareTo(Word word) {
            if (this.word.charAt(this.n) != word.word.charAt(this.n)) {
                return (this.word.charAt(this.n) - word.word.charAt(this.n));
            }
            return this.word.compareTo(word.word);
        }
    }
    
    public String[] solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();
        
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String s : strings) {
            pq.add(new Word(s, n));
        }
        
        while (!pq.isEmpty()) {
            answer.add(pq.poll().word);
        }
        
    
        return answer.stream().toArray(String[]::new);
    }
}
