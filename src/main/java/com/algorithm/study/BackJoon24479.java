package com.algorithm.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 알고리즘 수업 - 깊이 우선 탐색 1
 * https://www.acmicpc.net/problem/24479
 */
public class BackJoon24479 {
    private static int vertex;
    private static int edge;
    private static int startVertex;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] check;
    private static int count;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        startVertex = scanner.nextInt();

        check = new int[vertex + 1];
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int fromVertex = scanner.nextInt();
            int toVertex = scanner.nextInt();

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        dfs(startVertex);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int vertex) {
        check[vertex] = count;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVerTex = graph.get(vertex).get(i);

            if (check[newVerTex] == 0) {
                count++;
                dfs(newVerTex);
            }
        }
    }
}
