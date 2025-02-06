import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 100000);
        dist[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int r = 0; r < size; r++) {
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (dist[nx][ny] <= now[2]) continue;
                    if (board[nx][ny] == 0 && dist[nx][ny] > now[2]){
                        dist[nx][ny] = now[2];
                        queue.offer(new int[]{nx, ny, now[2]});
                    }
                    if (board[nx][ny] == 1 && dist[nx][ny] + 1 > now[2]) {
                        dist[nx][ny] = now[2] + 1;
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }


                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}