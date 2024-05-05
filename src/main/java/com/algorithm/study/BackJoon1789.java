package com.algorithm.study;

import java.util.Scanner;

public class BackJoon1789 {
    static long S;
    static long result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        S = scanner.nextLong();

        binarySearch(1, S);
        System.out.println(result);
    }

    static void binarySearch(long start, long end) {
        if (start > end) {
            return;
        }

        long mid = (start + end) / 2;
        long sum = calcSum(mid);
        if (S < sum) {
            binarySearch(start, mid - 1);
        } else if (S > sum) {
            result = Math.max(result, mid);
            binarySearch(mid + 1, end);
        } else {
            result = mid;
            return;
        }
    }

    static long calcSum(long mid) {
        return (mid * (mid + 1)) / 2;
    }
}
