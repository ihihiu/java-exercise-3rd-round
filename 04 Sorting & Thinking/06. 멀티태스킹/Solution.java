import java.util.*;
class Solution {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int n = tasks.length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{tasks[i], i});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(tasks);
        int preTime = 0;
        while (k > 0 && !list.isEmpty() && ((long) n * (list.peek()[0] - preTime) <= k)) {
                k -= n * (list.peek()[0] - preTime);
                preTime = list.poll()[0];
                n--;

        }
        if (list.isEmpty()) answer = -1;
        else {
            int idx = (int) k % n;
            Collections.sort(list, (a, b) -> a[1] - b[1]);
            answer = list.get(idx)[1] + 1;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
