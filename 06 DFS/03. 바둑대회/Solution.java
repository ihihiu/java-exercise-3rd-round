import java.util.*;
class Solution {
    static int answer, n;

    public static void dfs(int depth, int[][] cans, int white, int black, int wCnt, int bCnt) {
        if (wCnt > n / 2 || bCnt > n / 2) return;
        if (depth == n) {
            int diff = Math.abs(white - black);
            if (diff < answer) answer = Math.abs(white - black);
        } else {
            dfs(depth + 1, cans,white + cans[depth][0], black, wCnt + 1, bCnt);
            dfs(depth + 1, cans,white, black + cans[depth][1], wCnt, bCnt + 1);
        }
    }

    public int solution(int[][] cans){
        answer = 100000;
        n = cans.length;
        dfs(0, cans, 0, 0, 0, 0);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
