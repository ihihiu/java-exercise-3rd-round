import java.lang.reflect.Array;
import java.util.*;
class Solution {
    public boolean isUnique(int[] arr, int min) {
        int cnt = 0;
        for (int x : arr)
            if (x == min) cnt++;
        return cnt == 1;
    }

    public int getIdx(int[] x, int min) {
        for (int i = 0; i < 3; i++) {
            if (x[i] == min) return i;
        }
        return -1;
    }
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            int[] A = fruit[i];
            int minA = Arrays.stream(A).min().getAsInt();
            answer += minA;
            if (!isUnique(A, minA)) continue;
            for (int j = i + 1; j < n; j++) {
                if (ch[j] == 1) continue;
                int[] B = fruit[j];
                int minB = Arrays.stream(B).min().getAsInt();
                if (!isUnique(B, minB)) continue;
                int idxA = getIdx(A, minA);
                int idxB = getIdx(B, minB);
                if (idxA == idxB) continue;
                if (minA + 1 <= A[idxB] - 1 && minB + 1 <= B[idxA] - 1) {
                    ch[j] = 1;
                    answer += (minB + 2);
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}