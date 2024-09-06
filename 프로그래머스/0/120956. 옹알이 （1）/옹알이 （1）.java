class Solution {
    public int solution(String[] babbling) {
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "-");
            babbling[i] = babbling[i].replace("ye", "-");
            babbling[i] = babbling[i].replace("woo", "-");
            babbling[i] = babbling[i].replace("ma", "-");

        }
        int count = 0;
        for (int i = 0; i < babbling.length; i++) {
            if(babbling[i].equals("-") || babbling[i].equals("--") || babbling[i].equals("---") || babbling[i].equals("----")) {
                ++count;
            }
        }
        return count;
    }
}