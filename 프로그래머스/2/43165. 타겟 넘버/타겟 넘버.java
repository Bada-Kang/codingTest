import java.util.*;
class Solution {
    
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] newNumbers;
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        int size = numbers.length * 2;
        newNumbers = new int[size + 1];
        
        //새로운 배열 초기화
        for (int i = 1; i <= size; i++) {
            if (i % 2 == 1) {
                newNumbers[i] = numbers[(i+1)/2 - 1];
            } else {
                newNumbers[i] = numbers[(i+1)/2 - 1] * (-1);
            }
        }
                
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
        
        //연결리스트 연결
        graph.get(0).add(1);
        graph.get(0).add(2);
        for (int i = 1; i <= size - 2; i++) {
            if (i % 2 == 1) {
                graph.get(i).add(i+2);
                graph.get(i).add(i+3);
            } else {
                graph.get(i).add(i+1);
                graph.get(i).add(i+2);
            }
        }
        
        System.out.println(graph);
        
        int sum = 0;
        dfs(0, 0, target);
        
        return answer;
    }
    
    public static void dfs(int v, int sum, int target) {
        if (v != 0) sum += newNumbers[v];

        if (graph.get(v).isEmpty()) {
            if (sum == target) answer++;
            return;
        }

        for (int next : graph.get(v)) {
            dfs(next, sum, target);
        }      
    }
}