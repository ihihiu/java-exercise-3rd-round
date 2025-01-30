import java.util.*;
class Solution {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new int[]{plantTime[i], growTime[i]});
        }
        Collections.sort(arr, (a, b) -> b[1] - a[1]);
        int plan = 0;
        for (int i = 0; i < n; i++) {
            plan += arr.get(i)[0];
            answer = Math.max(answer, plan + arr.get(i)[1]);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}