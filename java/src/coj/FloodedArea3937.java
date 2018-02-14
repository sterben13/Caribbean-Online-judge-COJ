/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class FloodedArea3937 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String[] number = br.readLine().split("\\s+");
        int r = Integer.parseInt(number[0]);
        int c = Integer.parseInt(number[1]);
        int[][] arr = new int[r][c];
        String[] berland = new String[r];
        int max = 0;
        boolean p = true;
        for (int i = 0; i < r; i++) {
            berland[i] = br.readLine();
        }

        for (int i = 0; i < c; i++) {
            arr[0][i] = berland[0].charAt(i) == '*' ? 1 : 0;
            if (arr[0][i] > max) {
                max = arr[0][i];
                p = true;
            } else if (arr[0][i] == max) {
                p = false;
            }
        }

        for (int i = 1; i < r; i++) {
            arr[i][0] = berland[i].charAt(0) == '*' ? 1 : 0;
            if (arr[i][0] > max) {
                max = arr[i][0];
                p = true;
            } else if (arr[i][0] == max) {
                p = false;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (berland[i].charAt(j) == '*') {
                    arr[i][j] = (Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1]) + 1);
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        p = true;
                    } else if (arr[i][j] == max) {
                        p = false;
                    }
                } else if (berland[i].charAt(j) == '.') {
                    arr[i][j] = 0;
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        p = true;
                    } else if (arr[i][j] == max) {
                        p = false;
                    }
                }
            }
        }

        if (p) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println("");
   
        }
    }
}
/*
5 6
.***..
.***..
.*****
...***
...***
6 6
.***..
.***..
.***..
...***
...***
...***
2 11
.****.*****
.*****.****

1 23
.*.*.*..*.*.*..*.*..*.*

enrique cabrera aleksandrova




*/
