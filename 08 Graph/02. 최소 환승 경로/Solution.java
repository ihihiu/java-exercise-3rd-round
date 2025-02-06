import com.sun.source.tree.BinaryTree;

import java.util.*;
class Solution {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> sh = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] x = routes[i];
            for (int y : x) {
                if (!sh.containsKey(y)) sh.put(y, new HashSet<>());
                sh.get(y).add(i);
            }
        }
        int[] ch = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int key : sh.get(s)) {
            queue.offer(key);
            ch[key] = 1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int line = queue.poll();
                for (int x : routes[line]) {
                    if (x == e) return answer;
                    for (int y : sh.get(x)) {
                        if (ch[y] == 0) {
                            queue.offer(y);
                            ch[y] = 1;
                        }
                    }
                }
            }
            answer++;
        }



        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}