import java.util.*;
class Solution {
    public String solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x != ')') {
                stack.push(String.valueOf(x));
            } else {
                String tmp = "";
                while (!stack.peek().equals("(")) {
                    tmp = stack.pop() + tmp;
                }
                stack.pop();
                String cnt = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    cnt = stack.pop() + cnt;
                }
                String res = tmp;
                if (cnt != "") {
                    int n = Integer.valueOf(cnt);
                    for (int i = 1; i < n; i++) res += tmp;
                }
                stack.push(res);
            }
        }
        for (String x : stack) answer += x;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}