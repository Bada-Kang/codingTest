import java.util.*;

class Solution {
    public String[] solution(String[] record) {    
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : record) {
            String[] strArr = str.split(" ");
            if (!strArr[0].equals("Leave")) {
                hashMap.put(strArr[1], strArr[2]);
            }
        
        }
        
        ArrayList<String> arrayList = new ArrayList<>();
    
        for (int i = 0; i < record.length; i++) {
            String[] strArr = record[i].split(" ");
            if (strArr[0].equals("Enter") && hashMap.containsKey(strArr[1])) {
                arrayList.add(hashMap.get(strArr[1]) + "님이 들어왔습니다.");
            } else if (strArr[0].equals("Leave") && hashMap.containsKey(strArr[1])) {
                arrayList.add(hashMap.get(strArr[1]) + "님이 나갔습니다.");
            } else { 
                continue;
            }
        }
        
        //list.stream().toArray(String[]::new);
        return arrayList.stream().toArray(String[]::new);
    }
}