import java.util.*;
import java.util.zip.InflaterOutputStream;

class Solution {
    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 100000);
        dist[s[0]][s[1]] = 0;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pQ.offer(new int[]{s[0], s[1], 0});

        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            if (now[2] > dist[now[0]][now[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int move = 0;
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    move++;
                }
                nx -= dx[i];
                ny -= dy[i];
                if (dist[nx][ny] > now[2] + move) {
                    dist[nx][ny] = now[2] + move;
                    pQ.offer(new int[]{nx, ny, now[2] + move});
                }

            }
        }


        return dist[e[0]][e[1]] == 100000 ? -1 : dist[e[0]][e[1]];
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

