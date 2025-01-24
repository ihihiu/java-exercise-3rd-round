import java.util.*;
class Solution {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> sh = new HashMap<>();
        for (char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int x : sh.values()) {
            while (x != 0 && set.contains(x)) {
                x--;
                answer++;
            }
            set.add(x);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}