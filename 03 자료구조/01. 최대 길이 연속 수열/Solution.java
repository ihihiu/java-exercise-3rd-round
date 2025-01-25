import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> numbers = new HashSet<>();
        for (int x : nums) numbers.add(x);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x : numbers) arr.add(x);
        Collections.sort(arr);
        int cnt = 0;
        int pre = arr.get(0) - 1;
        for (int x : arr) {
            if (pre + 1 == x) {
                cnt++;
            } else {
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
            pre = x;
        }
        answer = Math.max(answer, cnt);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}