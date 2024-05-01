package com.algorithm.study;

import java.util.Arrays;
import java.util.Scanner;

public class BackJoon1920 {

    private static int[] A;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);

        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int target = scanner.nextInt();
            binarySearch(target, 0, N - 1);
        }
    }

    private static void binarySearch(int target, int start, int end) {
        if (start > end) {
            System.out.println(0);
            return;
        }

        int mid = (start + end) / 2;
        if (A[mid] == target) {
            System.out.println(1);
        } else if (A[mid] > target) {
            binarySearch(target, start, mid - 1);
        } else {
            binarySearch(target, mid + 1, end);
        }
    }
}