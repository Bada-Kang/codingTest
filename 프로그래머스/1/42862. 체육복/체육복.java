import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 모든 학생이 체육복을 1개 가지고 있다고 가정
        int[] student = new int[n];
        Arrays.fill(student, 1);

        // 잃어버린 학생들 처리
        for (int i : lost) {
            student[i - 1]--;
        }

        // 여벌을 가진 학생들 처리
        for (int i : reserve) {
            student[i - 1]++;
        }

        // 여벌 체육복을 앞뒤로 빌려주기
        for (int i = 0; i < n; i++) {
            if (student[i] == 2) { // 여벌이 있는 경우
                if (i - 1 >= 0 && student[i - 1] == 0) { // 앞번호 학생이 체육복이 없는 경우
                    student[i]--;
                    student[i - 1]++;
                } else if (i + 1 < n && student[i + 1] == 0) { // 뒷번호 학생이 체육복이 없는 경우
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        // 체육복을 가진 학생 수 계산
        int answer = 0;
        for (int i : student) {
            if (i >= 1) { // 체육복이 1개 이상인 학생
                answer++;
            }
        }

        return answer;
    }
}
