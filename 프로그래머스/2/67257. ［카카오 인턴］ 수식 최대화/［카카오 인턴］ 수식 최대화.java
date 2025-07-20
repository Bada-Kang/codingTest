import java.util.*;
import java.util.regex.*;

class Solution {
    public long solution(String expression) {
        long max = 0;
        // 연산자 우선순위 조합
        String[] orders = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};

        // 숫자와 연산자를 분리하여 tokens 리스트로 저장
        List<String> originTokens = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+|[+\\-*]").matcher(expression);
        while (m.find()) {
            originTokens.add(m.group());
        }

        for (String ops : orders) {
            List<String> tokens = new ArrayList<>(originTokens); // 매번 복사
            for (char op : ops.toCharArray()) {
                for (int i = 0; i < tokens.size(); ) {
                    if (tokens.get(i).equals(String.valueOf(op))) {
                        long left = Long.parseLong(tokens.get(i - 1));
                        long right = Long.parseLong(tokens.get(i + 1));
                        long result = calc(left, right, op);

                        // 결과로 교체: left op right -> result
                        tokens.remove(i + 1);
                        tokens.remove(i);
                        tokens.set(i - 1, String.valueOf(result));

                        // 다시 앞에서부터 보기 위해 i를 그대로 유지
                    } else {
                        i++;
                    }
                }
            }

            long result = Math.abs(Long.parseLong(tokens.get(0)));
            max = Math.max(max, result);
        }

        return max;
    }

    private long calc(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        throw new RuntimeException("Invalid operator");
    }
}