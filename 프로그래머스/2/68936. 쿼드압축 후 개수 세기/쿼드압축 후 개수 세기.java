import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        answer = calculate(arr);

        return answer;
    }

    public int[] calculate(int[][] arr) {
        int[] answer = {0, 0};
        int n = arr.length;
        if (Arrays.stream(arr).flatMapToInt(Arrays::stream).allMatch(value -> value == 0)) {
            //System.out.println("0으로만 이루어져있음!");
            answer[0] += 1;
            return answer;
        } else if (Arrays.stream(arr).flatMapToInt(Arrays::stream).allMatch(value -> value == 1)) {
            //System.out.println("1로만 이루어져있음!");
            answer[1] += 1;
            return answer;
        } else {
            while (n != 1) {
                int half_n = n/2;
                int[][] arr1 = new int[half_n][half_n];
                int[][] arr2 = new int[half_n][half_n];
                int[][] arr3 = new int[half_n][half_n];
                int[][] arr4 = new int[half_n][half_n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i < n/2) {
                            if (j < n/2) {
                                arr1[i][j] = arr[i][j];
                            } else {
                                arr2[i][j-(n/2)] = arr[i][j];
                            }
                        } else {
                            if (j < n/2) {
                                arr3[i-(n/2)][j] = arr[i][j];
                            } else {
                                arr4[i-(n/2)][j-(n/2)] = arr[i][j];
                            }
                        }
                    }
                }
                int[] result1 = calculate(arr1);
                answer[0] += result1[0]; answer[1] += result1[1];
                int[] result2 = calculate(arr2);
                answer[0] += result2[0]; answer[1] += result2[1];
                int[] result3 = calculate(arr3);
                answer[0] += result3[0]; answer[1] += result3[1];
                int[] result4 = calculate(arr4);
                answer[0] += result4[0]; answer[1] += result4[1];


                return answer;
            }
        }
        return answer;
    }
}