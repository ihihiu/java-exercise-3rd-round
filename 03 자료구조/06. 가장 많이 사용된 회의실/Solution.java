import java.util.*;
class Solution {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] ch = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for (int i = 0; i < n; i++) rooms.add(i);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int idx = 0;
        while (idx < meetings.length) {
            int[] now = meetings[idx];
            while (!pQ.isEmpty() && pQ.peek()[0] <= now[0]) {
                int[] x = pQ.poll();
                rooms.add(x[1]);
            }
            if (!rooms.isEmpty()) {
                int roomNumber = rooms.pollFirst();
                ch[roomNumber]++;
                pQ.offer(new int[]{now[1], roomNumber});
            } else {
                int[] x = pQ.poll();
                pQ.offer(new int[]{x[0] + (now[1] - now[0]), x[1]});
                ch[x[1]]++;
            }
            idx++;
        }
        int max = Arrays.stream(ch).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (ch[i] == max) {
                answer = i;
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}