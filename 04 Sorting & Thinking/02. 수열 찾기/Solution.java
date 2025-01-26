import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n / 2];
        HashMap<Integer, Integer> sh = new HashMap<>();
        for (int x : nums) sh.put(x, sh.getOrDefault(x, 0) + 1);
        Arrays.sort(nums);
        int idx = 0;
        for (int x : nums) {
            if (sh.get(x) == 0) continue;
            sh.put(x, sh.get(x) - 1);
            sh.put(2 * x, sh.get(2 * x) - 1);
            answer[idx++] = x;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}