import java.util.*;
class Solution {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> queue = new LinkedList<>();
        int time = 0;
        int idx = 0;
        while (!list.isEmpty() || !queue.isEmpty()) {
            if (queue.isEmpty() && time < list.peek()[0]) time = list.peek()[0];
            while (!list.isEmpty() && list.peek()[0] <= time) {
                int[] x = list.poll();
                queue.offer(new int[]{x[1], x[2]});
            }
            Collections.sort(queue, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int[] x = queue.poll();
            answer[idx++] = x[1];
            time += x[0];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}