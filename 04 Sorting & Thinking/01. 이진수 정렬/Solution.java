import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cnt = 0;
            while (num != 0) {
                if (num % 2 == 1) cnt++;
                num /= 2;
            }
            arr.add(new int[]{cnt, nums[i]});
        }
        Collections.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            answer[i] = arr.get(i)[1];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}