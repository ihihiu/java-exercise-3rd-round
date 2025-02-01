import java.util.*;
class Solution {
    int[] dp;
    int n;

    public int dfs(int start, String s) {
        if (dp[start] > 0) return dp[start];
        if (start < n && s.charAt(start) == '0') return 0;
        if (start == n || start == n - 1) return 1;
        else {
            int res = dfs(start + 1, s);
            int tmp = Integer.valueOf(s.substring(start, start + 2));
            if (tmp <= 26) res += dfs(start + 2, s);
            return res;
        }
    }
    public int solution(String s){
        dp = new int[101];
        n = s.length();
        int answer = dfs(0, s);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}