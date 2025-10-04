import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> bridge = new ArrayDeque<>();

        int time = 1;
        int totalWeight = 0;

        for (int truck : truck_weights) {
            // 다리에 올릴 수 없는 경우: 트럭을 내리며 시간 점프
            while (totalWeight + truck > weight || bridge.size() >= bridge_length) {
                int[] passed = bridge.poll();
                totalWeight -= passed[0];
                time = passed[1];
            }

            // 트럭을 다리에 올리고, 내릴 시각을 저장
            bridge.add(new int[] {truck, time++ + bridge_length});
            totalWeight += truck;

            // 트럭을 올린 후, 동시에 내려야 할 트럭이 있는지 확인
            if (time >= bridge.peek()[1]) {
                totalWeight -= bridge.poll()[0];
            }
        }

        // 마지막 트럭의 내릴 시각이 곧 전체 시간
        return bridge.peekLast()[1];
    }

}