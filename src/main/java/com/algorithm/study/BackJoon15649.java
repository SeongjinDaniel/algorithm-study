package com.algorithm.study;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * N과M (1)
 * https://www.acmicpc.net/problem/15649
 */
public class BackJoon15649 {

    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static boolean[] visit;
    private static int[] arrays;

    public static void main(String[] args) {

        sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        visit = new boolean[N];
        arrays = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int arr : arrays) {
                sb.append(arr).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arrays[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
        return;
    }
}
