import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][] ch = new int[n][n];
        int[][] res = new int[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<int[]> buildings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    buildings.add(new int[]{i, j});
                }
                if (board[i][j] == 2) {
                    ch[i][j] = -1;
                }
            }
        }
        int cnt = buildings.size();
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 1; r <= cnt; r++) {
            queue.offer(buildings.get(r - 1));
            int L = 0;
            while (!queue.isEmpty()) {
                L++;
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] != 0) continue;
                        if (ch[nx][ny] == r - 1) {
                            queue.offer(new int[]{nx, ny});
                            ch[nx][ny] = r;
                            res[nx][ny] += L;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0 || ch[i][j] != cnt) continue;
                if (res[i][j] < answer) answer = res[i][j];
            }
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}