import java.util.*;
class Solution {
    public int solution(int[] pool, int a, int b, int home){
        int answer = 0;
        int[][] ch = new int[2][10001];
        for (int x : pool) {
            ch[0][x] = 1;
            ch[1][x] = 1;
        }

        if (home == 0) return answer;

        //{위치, 앞(0)/뒤(1)}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int nA = now[0] + a;
                if (nA <= 10000 && ch[now[1]][nA] == 0) {
                    ch[now[1]][nA] = 1;
                    queue.offer(new int[]{nA, 0});
                }
                int nB = now[0] - b;
                if (nA == home || nB == home) return answer;
                if (nB < 0 || now[1] == 1 || ch[now[1]][nB] == 1) continue;
                ch[now[1]][nB] = 1;
                queue.offer(new int[]{nB, 1});
            }
        }


        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}