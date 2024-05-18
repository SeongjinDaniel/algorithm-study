package com.algorithm.study;

import java.util.*;

/**
 * 런타임 에러
 */
public class BackJoon11725TwoDimentionalArray {

    private static int vertex;
    private static int[][] graph;
    private static boolean[] check;
    private static Map<Integer, Integer> resultMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();

        graph = new int[vertex + 1][vertex + 1];
        check = new boolean[vertex + 1];

        for (int i = 0; i < vertex - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        bfs(1);
        for (int i = 2; i <= vertex; i++) {
            System.out.println(resultMap.get(i));
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();

            for (int i = 1; i <= vertex; i++) {
                if (graph[v][i] == 1 && !check[i]) {
                    resultMap.put(i, v);
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}