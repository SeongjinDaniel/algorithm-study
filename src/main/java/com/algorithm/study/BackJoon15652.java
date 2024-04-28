package com.algorithm.study;

import java.util.Scanner;

public class BackJoon15652 {

    private static int N;
    private static int M;
    private static int[] arrays;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        sb = new StringBuilder();
        arrays = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arrays) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arrays[depth] = i;
            dfs(i, depth + 1);
        }

    }
}