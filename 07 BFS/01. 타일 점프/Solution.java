import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        int[] ch = new int[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{nums[0], 0});
        ch[0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if (now[0] != 0) {
                    for (int j = 1; j <= now[0]; j++) {
                        int x = now[1] + j;
                        if (x == n - 1) return answer;
                        if (x < n && ch[x] == 0) {
                            ch[x] = 1;
                            queue.offer(new int[]{nums[x], x});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}