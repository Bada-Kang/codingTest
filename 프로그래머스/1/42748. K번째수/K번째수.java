import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for (int[] command : commands) {
            int[] slicedArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            slicedArray = Arrays.stream(slicedArray).sorted().toArray();
            answer[i] = slicedArray[command[2]-1];
            i++;
        }

        return answer;
    }
}