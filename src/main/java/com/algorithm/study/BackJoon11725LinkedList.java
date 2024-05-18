package com.algorithm.study;

import java.util.*;

public class BackJoon11725LinkedList {
    private static int vertex;
    private static boolean[] check;
    private static LinkedList<Integer>[] graph;
    private static Map<Integer, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();

        check = new boolean[vertex + 1];
        graph = new LinkedList[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < vertex - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        bfs_list(1);
        for (int i = 2; i <= vertex; i++) {
            System.out.println(resultMap.get(i));
        }
    }

    private static void bfs_list(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();

            for (int w : graph[v]) {
                if (!check[w]) {
                    q.add(w);
                    check[w] = true;
                    resultMap.put(w, v);
                }
            }
        }
    }
}
