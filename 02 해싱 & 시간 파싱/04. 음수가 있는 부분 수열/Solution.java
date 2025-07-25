import java.util.*;
class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;
        HashMap<Integer, Integer> acc = new HashMap<>();
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum == m) answer++;
            else if (acc.containsKey(sum - m)) answer += acc.get(sum - m);
            acc.put(sum, acc.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}