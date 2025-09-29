import java.util.Arrays;
import java.util.Collections;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        // n * n 을 위한 n 값 리스트
        // 비어있는 공간은 -1로 표기되어있음.
        
        // 1. 
        
        Arrays.sort(mats);
        for (int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;   
        }   
        // mats는 내림차순으로 정리되어 맨 앞 인덱스부터 값이 크다.
        // mats[0], mats[1] ... 번 반복
        // park의 원소를 하나씩 찾으면서 -1인 원소를 찾는다.
        // -1을 찾으면, 예를 들어 mats[0] = 5, mats[1] = 3 이면, -1으 인덱스를 시작으로 5x5가 -1인지 하나씩 탐색
        // 만약 5x5가 아니라는 걸 확인한 순간부터 바로 3x3이 되는지 탐색 ...
        

        int max = -1;
        
        for (int c = 0; c < park.length; c++) {
            for (int r = 0; r < park[0].length; r++) {
                int success = 1;
                if (park[c][r].equals("-1")){ //여기 중요
                    for(int k=0; k < mats.length; k++){ //1. 구간설정은 이렇게 해줘야함
                        success = 1; //success는 여기있어야 함 + boolean으로 해주면 좋음

                        //범위 벗어나면 건너뛰기
                        if (c + mats[k] > park.length || r + mats[k] > park[0].length)
                            continue;


                        for (int i=c; i < c+mats[k]; i++){ //2. 구간설정은 이렇게 해줘야함
                            for (int j=r; j < r+mats[k] ; j++){
                                if (!park[i][j].equals("-1")){
                                    success = 0;
                                    break;
                                }
                            }

                            if (success == 0)
                                break;

                        }
                        if (success == 1) {
                            max = Math.max(max, mats[k]);  
                        }
                    }
                }

            }
        }
        
        return max; //6.문제 조건 읽기 -1로 처리해줘야함
        
        
    }
}



// class Solution {
//     public int solution(int[] mats, String[][] park) {
//         int maxScale = 0;

//         for (int i = 0; i < park.length; i++) {
//             for (int j = 0; j < park[i].length; j++) {
//                 int scale = 0;
//                 boolean isTrue = true;

//                 // 현재 위치에서 가능한 최대 크기를 검증
//                 while (isTrue && i + scale < park.length && j + scale < park[i].length) {
//                     // scale + 1 크기의 사각형 영역을 검사
//                     for (int k = 0; k <= scale; k++) {
//                         for (int l = 0; l <= scale; l++) {
//                             if (!park[i + k][j + l].equals("-1")) {
//                                 isTrue = false;
//                                 break;
//                             }
//                         }
//                         if (!isTrue) {
//                             break;
//                         }
//                     }

//                     if (isTrue) {
//                         scale++;
//                     }
//                 }

//                 maxScale = Math.max(maxScale, scale);  // 각 위치에서 최대 scale을 기록
//             }
//         }

//         int answer = 0;
//         for (int mat : mats) {
//             if (mat <= maxScale) {
//                 answer = Math.max(answer, mat);
//             }
//         }

//         return answer == 0 ? -1 : answer;
//     }
// }
