import java.util.*;
class Solution {
    public int solution(int[] keypad, String password){
        int answer = 0;
        int pre = password.charAt(0) - '0';
        int preX = 0, preY = 0, nowX = 0, nowY = 0;
        for (int i = 0; i < 9; i++) {
            if (keypad[i] == pre) {
                preX = i / 3;
                preY = i % 3;
                break;
            }
        }
        for (int i = 1; i < password.length(); i++) {
            int now = password.charAt(i) - '0';
            if (now == pre) continue;
            for (int j = 0; j < 9; j++) {
                if (keypad[j] == now) {
                    nowX = j / 3;
                    nowY = j % 3;
                    break;
                }
            }
            if (Math.abs(preX - nowX) > 1 || Math.abs(preY - nowY) > 1) answer++;
            answer++;
            pre = now;
            preX = nowX;
            preY = nowY;

        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}