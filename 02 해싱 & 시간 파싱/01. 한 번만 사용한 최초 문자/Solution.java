import java.util.*;
class Solution {
    public int solution(String s){
        int answer = -1;
        HashMap<Character, Integer> idxs = new HashMap<>();
        HashMap<Character, Integer> cnts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!cnts.containsKey(x)) idxs.put(x, i + 1);
            cnts.put(x, cnts.getOrDefault(x, 0) + 1);
        }
        for (char x : cnts.keySet()) {
            if (cnts.get(x) == 1) {
                answer = idxs.get(x);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}