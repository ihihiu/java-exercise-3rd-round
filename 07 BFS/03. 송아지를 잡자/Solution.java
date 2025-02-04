import java.util.*;
class Solution {
    public int solution(int s, int e){
        int answer = 0;

        // +1 -1 = 0 이므로 2레벨 전에 방문한 위치가 또 나오게 됨
        int[][] ch = new int[2][200001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[0][s] = 1;
        while (!queue.isEmpty()) {
            answer++;
            e += answer;
            if (e > 200000) return -1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int nx : new int[]{now + 1, now - 1, now * 2}) {
                    if (nx < 0 || nx > 200000 || ch[answer % 2][nx] == 1) continue;
                    ch[answer % 2][nx] = 1;
                    queue.offer(nx);

                }
            }
            if (ch[answer % 2][e] == 1) return answer;
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}