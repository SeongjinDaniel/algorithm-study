package com.algorithm.study;

import java.util.Scanner;

/**
 * 빙고
 * https://www.acmicpc.net/problem/2578
 */
public class BackJoon15652 {

    private static int[][] bingo;
    private static boolean[][] checkArray;

    private static final int ROW = 5;
    private static final int COLUMN = 5;
    private static int bingoCount = 0;

    public static void main(String[] args) {
        bingo = new int[ROW][COLUMN];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                bingo[i][j] = scanner.nextInt();
            }
        }

        for (int k = 0; k < ROW * COLUMN; k++) {
            int callNumber = scanner.nextInt();

            // 사회자가 부른 수가 있으면 0으로 변경
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) {
                    if (bingo[i][j] == callNumber) {
                        bingo[i][j] = 0;
                    }
                }
            }

            rCheck();
            cCheck();
            lrCheck();
            rrCheck();

            if (bingoCount >= 3) {
                System.out.println(k + 1);
                break;
            }
            bingoCount = 0;
        }


    }

    /**
     * 가로 빙고 체크
     */
    public static void rCheck() {
        for (int i = 0; i < ROW; i++) {
            int zeroCount = 0;
            for (int j = 0; j < COLUMN; j++) {
                if (bingo[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == ROW) {
                bingoCount++;
            }
        }
    }

    /**
     * 세로 빙고 체크
     */
    public static void cCheck() {
        for (int i = 0; i < ROW; i++) {
            int zeroCount = 0;
            for (int j = 0; j < COLUMN; j++) {
                if (bingo[j][i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == COLUMN) {
                bingoCount++;
            }
        }
    }

    /**
     * 좌상단 아래로 사선 빙고 체크
     */
    public static void lrCheck() {
        int zeroCount = 0;
        for (int i = 0; i < ROW; i++) {
            if (bingo[i][i] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == ROW) {
            bingoCount++;
        }
    }

    /**
     * 우상단 아래로 사선 빙고 체크
     */
    public static void rrCheck() {
        int zeroCount = 0;
        for (int i = 0; i < ROW; i++) {
            if (bingo[i][ROW - i - 1] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == ROW) {
            bingoCount++;
        }
    }
}