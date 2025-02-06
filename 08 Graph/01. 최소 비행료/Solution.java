import java.util.*;
class Solution {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});

        for (int r = 0; r <= k; r++){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int[] x : graph.get(now[0])) {
                    if (now[1] > distance[x[0]]) continue;
                    if (now[1] + x[1] < distance[x[0]]) {
                        distance[x[0]] = now[1] + x[1];
                        queue.offer(new int[]{x[0], now[1] + x[1]  });
                    }
                }
            }
        }


        return distance[e] == Integer.MAX_VALUE ? -1 : distance[e];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}