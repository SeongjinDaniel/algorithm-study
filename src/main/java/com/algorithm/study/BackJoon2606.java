package com.algorithm.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BackJoon2606 {
    private static int vertex;
    private static int edge;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] check;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }
        check = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int vertex) {
        check[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            if (!check[newVertex]) {
                count++;
                dfs(newVertex);
            }
        }
    }
}