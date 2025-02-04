import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        int[][] ch = new int[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || ch[nx][ny] == 1 || board[nx][ny] == 1) continue;
                    if (nx == n - 1 && ny == n - 1) return answer;
                    ch[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}