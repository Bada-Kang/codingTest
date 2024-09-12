class Solution {
    public int solution(int[] mats, String[][] park) {
        int maxScale = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                int scale = 0;
                boolean isTrue = true;

                // 현재 위치에서 가능한 최대 크기를 검증
                while (isTrue && i + scale < park.length && j + scale < park[i].length) {
                    // scale + 1 크기의 사각형 영역을 검사
                    for (int k = 0; k <= scale; k++) {
                        for (int l = 0; l <= scale; l++) {
                            if (!park[i + k][j + l].equals("-1")) {
                                isTrue = false;
                                break;
                            }
                        }
                        if (!isTrue) {
                            break;
                        }
                    }

                    if (isTrue) {
                        scale++;
                    }
                }

                maxScale = Math.max(maxScale, scale);  // 각 위치에서 최대 scale을 기록
            }
        }

        int answer = 0;
        for (int mat : mats) {
            if (mat <= maxScale) {
                answer = Math.max(answer, mat);
            }
        }

        return answer == 0 ? -1 : answer;
    }
}
