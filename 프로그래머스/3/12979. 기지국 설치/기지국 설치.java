class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //처음
        if (stations[0] - w - 1 > 0) {
            int range = w*2 + 1;
            int cur = stations[0] - w - 1;
            if (cur % range == 0) {
                answer += cur / range;
            } else {
                answer += (cur / range) + 1;
            }
        }
        System.out.println(answer);
        //중간
        for (int i = 1; i < stations.length; i++) {
            int range = w*2 + 1;
            int cur = stations[i] - stations[i-1] - (2*w) - 1;
            
            if (cur > 0) {
                if (cur % range == 0) {
                    answer += cur / range;
                } else {
                    answer += (cur / range) + 1;
                }
            }
            
        }
        System.out.println(answer);

        //마지막
        if (n - stations[stations.length-1] - w > 0) {
            int range = w*2 + 1;
            int cur = n - stations[stations.length-1] - w;
            if (cur % range == 0) {
                answer += cur / range;
            } else {
                answer += (cur / range) + 1;
            }
        }
        System.out.println(answer);


        return answer;
    }
}