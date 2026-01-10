class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        // 디딤돌 숫자의 최대값인 2억으로 설정 (문제 조건에 따름)
        int right = 200000000; 
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 'mid'명이 건널 수 있는지 확인
            if (check(mid, stones, k)) {
                ans = mid;      // 가능하면 일단 정답 후보로 저장
                left = mid + 1; // 더 많은 인원이 가능한지 보러 감
            } else {
                right = mid - 1; // 불가능하면 인원을 줄임
            }
        }

        return ans;
    }

    // 핵심: mid명이 건널 때, 연속으로 못 밟는 돌이 k개 이상인지 확인
    public boolean check(int mid, int[] stones, int k) {
        int zeroCount = 0; // 연속으로 0이 된 돌의 개수

        for (int stone : stones) {
            // 돌의 숫자가 건너려는 인원(mid)보다 작으면 못 밟음
            if (stone < mid) {
                zeroCount++;
            } else {
                // 밟을 수 있는 돌을 만나면 다시 0부터 셈
                zeroCount = 0;
            }

            // 못 밟는 돌이 연속 k개가 되는 순간, mid명은 못 건넘
            if (zeroCount >= k) {
                return false;
            }
        }
        return true;
    }
}