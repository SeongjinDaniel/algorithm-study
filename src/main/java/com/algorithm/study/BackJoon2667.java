package com.algorithm.study;

import java.util.*;

/**
 * BFS
 * 단지 번호 붙이기
 */
public class BackJoon2667 {

    private static int n;
    private static int[][] map;
    private static int count;
    private static int danjiNumber;
    private static List<Integer> results = new ArrayList<>();
    // 상하좌우
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (map[i][j] == 1) {
                    danjiNumber++;
                    bfs(i, j);
                    results.add(count);
                }
            }
        }

        System.out.println(danjiNumber);
        Collections.sort(results);
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = 0;

        while(!q.isEmpty()) {
            count++;
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dirX[i];
                int ny = now[1] + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.add(new int[]{nx, ny});
                }
            }

        }
    }
}
