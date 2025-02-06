import java.util.*;
class Solution {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        String[] answer = new String[n];
        int[] indegree = new int[n];
        HashMap<String, Integer> idxs = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> relation = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxs.put(subjects[i], i);
            relation.put(i, new ArrayList<>());
        }
        for (String x : course) {
            int a = idxs.get(x.split(" ")[0]);
            int b = idxs.get(x.split(" ")[1]);
            indegree[a]++;
            relation.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer[i++] = subjects[now];
            for (int key : relation.get(now)) {
                if (--indegree[key] == 0) queue.offer(key);
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        for (String x : T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}))
            System.out.print(x + " ");
        //System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}