import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = 0;
        int x = 0, y = 0, tx = 0, ty = 0;
        //상, 우, 하, 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d = 0, td = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                }
                if (board[i][j] == 3) {
                    tx = i;
                    ty = j;
                }
            }
        }
        while (answer < 10000) {
            answer++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            int tnx = tx + dx[td];
            int tny = ty + dy[td];
            if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10 || board[nx][ny] == 1) {
                d = (d + 1) % 4;
            }
            else {
                x = nx;
                y = ny;
            }
            if (tnx < 0 || tnx >= 10 || tny < 0 || tny >= 10 || board[tnx][tny] == 1) {
                td = (td + 1) % 4;
            }
            else {
                tx = tnx;
                ty = tny;
            }
            if (tx == x && ty == y) break;

        }
        return answer == 100000 ? 0 : answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}