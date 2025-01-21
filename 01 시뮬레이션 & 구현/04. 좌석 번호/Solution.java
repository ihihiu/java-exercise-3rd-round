import java.util.*;
class Solution {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if (k > c * r) return answer;
        //상, 우, 하, 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] ch = new int[r][c];
        int d = 0;
        int ord = 0;
        int x = r, y = 0;
        while (ord < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || ch[nx][ny] == 1) {
                d = (d + 1) % 4;
            }
            else {
                ch[nx][ny] = 1;
                x = nx;
                y = ny;
                ord++;
            }

        }
        answer[0] = y + 1;
        answer[1] = x + 1;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}