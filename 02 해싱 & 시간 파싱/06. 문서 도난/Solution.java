import java.util.*;
class Solution {
    public int getTime(String x) {
        return Integer.valueOf(x.split(":")[0]) * 60 + Integer.valueOf(x.split(":")[1]);
    }
    public String[] solution(String[] reports, String times){
        int start = getTime(times.split(" ")[0]);
        int end = getTime(times.split(" ")[1]);

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < reports.length; i++) {
            int t = getTime(reports[i].split(" ")[1]);
            if (t >= start && t <= end) res.add(new int[]{t, i});
        }
        Collections.sort(res, (a, b) -> a[0] - b[0]);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = reports[res.get(i)[1]].split(" ")[0];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}