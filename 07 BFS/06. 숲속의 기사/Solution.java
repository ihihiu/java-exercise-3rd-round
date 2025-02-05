import java.util.*;
class Solution {
    public int solution(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<int[]> berries = new ArrayList<>();
        int x = 0, y = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    int L = 0;
                    while (!queue.isEmpty()) {
                        L++;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] now = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = now[0] + dx[l];
                                int ny = now[1] + dy[l];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1 || dist[nx][ny] != 0)
                                    continue;
                                dist[nx][ny] = L;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
                if (board[i][j] == 3) {
                    x = i;
                    y = j;
                }
                if (board[i][j] == 4) berries.add(new int[]{i, j});
            }
        }

        int[][] ch = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int cnt = berries.size();
        int L = 0;
        while (!queue.isEmpty() || cnt > 0) {
            int size = queue.size();
            L++;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1 || ch[nx][ny] == 1) continue;
                    if (board[nx][ny] == 4) {
                        cnt--;
                        dist[nx][ny] += L;
                    }
                    ch[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int[] now : berries) {
            if (dist[now[0]][now[1]] < answer) answer = dist[now[0]][now[1]];
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}