import java.util.*;
class Solution {
    static ArrayList<String> res;
    static int n;

    public static void dfs(int depth, int start, String tmp, String s) {
        if (depth == 4 && start == n) {
            res.add(tmp.substring(0, tmp.length() - 1));
        } else {
            String x = "";
            if (start < n) {
                x += s.charAt(start);
                dfs(depth + 1, start + 1, tmp + x + ".", s);
                if (x.equals("0")) return;
                if (start + 1 < n) {
                    x += s.charAt(start + 1);
                    dfs(depth + 1, start + 2, tmp + x + ".", s);
                }
                if (start + 2 < n) {
                    x += s.charAt(start + 2);
                    if (Integer.valueOf(x) <= 255) {
                        dfs(depth + 1, start + 3, tmp + x + ".", s);
                    }
                }
            }
        }
    }

    public String[] solution(String s){
        n = s.length();
        res = new ArrayList<>();
        dfs(0, 0, "", s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}