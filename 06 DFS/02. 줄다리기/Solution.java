import java.util.*;
class Solution {
    static int answer;
    static int[][] relation;
    static int[] ch;

    static public void dfs(int depth, int pre) {
        if (depth == 7) {
            answer++;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (ch[i] == 0 && relation[i][pre] == 0) {
                    ch[i] = 1;
                    dfs(depth + 1, i);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        relation = new int[8][8];
        ch = new int[8];
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
