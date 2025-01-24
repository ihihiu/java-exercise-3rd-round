import java.util.*;
class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> sh = new HashMap<>();
        int max = 0;
        for (char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
            max = Math.max(max, sh.get(x));
        }
        for (int i = 0; i < 5; i++) {
            char x = (char) ('a' + i);
            if (!sh.containsKey(x)) answer[i] = max;
            else answer[i] = max - sh.get(x);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
