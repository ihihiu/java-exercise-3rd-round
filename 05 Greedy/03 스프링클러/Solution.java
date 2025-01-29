import java.util.*;
class Solution {
    public int solution(int n, int[] nums){
        int answer = 0;
        int idx = 0;
        int start = 0, end = 0;
        while (idx < n) {
            if (idx - nums[idx] > start) return -1;
            int max = end;
            while (idx - nums[idx] <= start) {
                if (idx + nums[idx] > max) {
                    max = idx + nums[idx];
                }
                idx++;
            }
            answer++;
            if (max >= n) return answer;
            start = max;
            end = max;
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}