import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        int preState = 1, idx = 0, cnt = 0;
        LinkedList<Integer> outList = new LinkedList<>();
        LinkedList<Integer> inList = new LinkedList<>();
        for (int time = arrival[0]; time <= arrival[n - 1] * n; time++) {
            if (cnt == n) break;
            if (idx < n && inList.isEmpty() && outList.isEmpty() && time < arrival[idx]) {
                time = arrival[idx];
                preState = 1;
            }
            while (idx < n && arrival[idx] == time) {
                if (state[idx] == 0) inList.add(idx);
                else outList.add(idx);
                idx++;
            }
            //들어오는
            if (preState == 0) {
                if (!inList.isEmpty()) {
                    answer[inList.poll()] = time;
                } else {
                    answer[outList.poll()] = time;
                    preState = 1;
                }
            } else {
                if (!outList.isEmpty()) {
                    answer[outList.poll()] = time;
                } else {
                    answer[inList.poll()] = time;
                    preState = 0;
                }
            }
            cnt++;
        }



        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}