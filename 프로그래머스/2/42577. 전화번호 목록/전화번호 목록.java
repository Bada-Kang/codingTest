import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String phone : phone_book) {
            map.put(phone, 1);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    return false; 
                }
            }
        }
        return true; 
    }
}