import java.util.*;
class Solution {
    public String solution(String[] votes, int k){
        String answer = " ";
        HashMap<String, Integer> nums = new HashMap<>();
        HashMap<String, ArrayList<String>> arr = new HashMap<>();
        for (String x : votes) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            if (!arr.containsKey(b)) arr.put(b, new ArrayList<>());
            nums.put(b, nums.getOrDefault(b, 0) + 1);
            arr.get(b).add(a);
        }
        HashMap<String, Integer> present = new HashMap<>();
        int max = 0;
        for (String key : nums.keySet()) {
            if (nums.get(key) >= k) {
                for (String name : arr.get(key)) {
                    present.put(name, present.getOrDefault(name, 0) + 1);
                    max = Math.max(max, present.get(name));
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String key : present.keySet()) {
            if (present.get(key) == max) res.add(key);
        }
        Collections.sort(res);
        answer = res.get(0);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}