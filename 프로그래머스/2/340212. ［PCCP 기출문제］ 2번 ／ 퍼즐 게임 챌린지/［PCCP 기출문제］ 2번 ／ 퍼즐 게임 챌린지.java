import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = Arrays.stream(diffs).min().getAsInt();
        int maxLevel = Arrays.stream(diffs).max().getAsInt();
        int level = minLevel;

        while (minLevel <= maxLevel) {
            int midLevel = (minLevel + maxLevel) / 2;
            long total_time = calculateTotalTime(diffs, times, midLevel);

            if (total_time > limit) {
                minLevel = midLevel + 1;
            } else {
                level = midLevel;
                maxLevel = midLevel - 1;
            }
        }

        return level;
    }

    private long calculateTotalTime(int[] diffs, int[] times, int level) {
        long total_time = 0;
        int time_prev = 1;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            if (level >= diff) {
                total_time += time_cur;
            } else {
                total_time += (time_prev + time_cur) * (diff - level) + time_cur;
            }
            time_prev = time_cur;
        }

        return total_time;
    }
}
