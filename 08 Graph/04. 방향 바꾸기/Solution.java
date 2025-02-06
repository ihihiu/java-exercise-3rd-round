import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        //0(상), 1(우), 2(좌), 3(하)
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 100000);
        dist[0][0] = 0;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pQ.offer(new int[]{0, 0, 0});

        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            if (now[2] > dist[now[0]][now[1]]) continue;
            int dir = board[now[0]][now[1]] % 4;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dir == i && dist[nx][ny] > now[2]) {
                    dist[nx][ny] = now[2];
                    pQ.offer(new int[]{nx, ny, now[2]});
                } else {
                    if (dist[nx][ny] > now[2] + 1) {
                        dist[nx][ny] = now[2] + 1;
                        pQ.offer(new int[]{nx, ny, now[2] + 1});

                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}