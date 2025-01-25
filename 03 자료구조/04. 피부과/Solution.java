import java.util.*;
class Solution {
    public int getTime(String x) {
        return Integer.valueOf(x.split(":")[0]) * 60 + Integer.valueOf(x.split(":")[1]);
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        LinkedList<int[]> list = new LinkedList<>();
        for (String x : enter) {
            list.add(new int[]{getTime(x.split(" ")[0]), laser[Integer.valueOf(x.split(" ")[1])]});
        }
        int cnt = 1;
        int[] first = list.poll();
        int endTime = first[0] + first[1];
        Queue<int[]> queue = new ArrayDeque<>();
        while (true) {
            while (cnt < n && list.peek()[0] < endTime) {
                int[] x = list.poll();
                queue.offer(x);
                cnt++;
            }
            answer = Math.max(answer, queue.size());
            if (!list.isEmpty() && list.peek()[0] == endTime) {
                int[] x = list.poll();
                queue.offer(x);
                cnt++;
            }
            if (cnt == n) break;
            if (!queue.isEmpty()) endTime += queue.poll()[1];
            else {
                endTime = list.peek()[0];
            }

        }



        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}