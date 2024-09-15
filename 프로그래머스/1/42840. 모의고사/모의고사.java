import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> array = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if ((i%5 == 0 && answers[i] == 1) || (i%5 == 1 && answers[i] == 2) || (i%5 == 2 && answers[i] == 3) || (i%5 == 3 && answers[i] == 4) || (i%5 == 4 && answers[i] == 5)) {
                count1 += 1;
            }
            if ((i%8 == 0 && answers[i] == 2) || (i%8 == 1 && answers[i] == 1) || (i%8 == 2 && answers[i] == 2) || (i%8 == 3 && answers[i] == 3) || (i%8 == 4 && answers[i] == 2) || (i%8 == 5 && answers[i] == 4) || (i%8 == 6 && answers[i] == 2) || (i%8 == 7 && answers[i] == 5)) {
                count2 += 1;
            }
            if ((i%10 == 0 && answers[i] == 3) || (i%10 == 1 && answers[i] == 3) || (i%10 == 2 && answers[i] == 1) || (i%10 == 3 && answers[i] == 1) || (i%10 == 4 && answers[i] == 2) || (i%10 == 5 && answers[i] == 2) || (i%10 == 6 && answers[i] == 4) || (i%10 == 7 && answers[i] == 4) || (i%10 == 8 && answers[i] == 5) || (i%10 == 9 && answers[i] == 5)) {
                count3 += 1;
            }
        }

        int max = count1 >= count2 ? count1 : count2;
        max = max >= count3 ? max : count3;

        if (count1 == max) {
            array.add(1);
        }
        if (count2 == max) {
            array.add(2);
        }
        if (count3 == max) {
            array.add(3);
        }


        return array.stream().mapToInt(Integer::intValue).toArray();
    }
}