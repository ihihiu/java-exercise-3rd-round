import java.util.*;
class Solution {
    static String answer;
    static String target;
    static int m;
    static int[] ch;

    static public void dfs(int depth, String tmp) {
        if (depth == m) {
            if (tmp.compareTo(target) <= 0) return;
            if (tmp.compareTo(answer) < 0) answer = tmp;
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(depth + 1, tmp + target.charAt(i));
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n){
        target = String.valueOf(n);
        answer = "9999999";
        m = target.length();
        ch = new int[m];
        dfs(0, "");
        return answer == "9999999" ? -1 : Integer.valueOf(answer);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}