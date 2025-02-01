import java.util.*;
class Solution {
    static HashMap<Character, Integer> sh;
    static int n;
    static ArrayList<String> res;

    public static void dfs(int depth, String tmp) {
        if (depth == n / 2) {
            res.add(tmp);
        } else {
            for (char key : sh.keySet()) {
                if (sh.get(key) > 0) {
                    sh.put(key, sh.get(key) - 2);
                    dfs(depth + 1, key + tmp + key);
                    sh.put(key, sh.get(key) + 2);
                }
            }
        }
    }

    public String[] solution(String s){
        n = s.length();
        sh = new HashMap<>();
        res = new ArrayList<>();
        for (char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        String str = "";
        int cnt = 0;
        for (char key : sh.keySet()) {
            if (sh.get(key) % 2 == 1) {
                cnt++;
                if (cnt > 1) return new String[]{};
                str = String.valueOf(key);
                sh.put(key, sh.get(key) - 1);
            }
        }
        dfs(0, str);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}