/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class NewHouse1002 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        int t, n;
        try {
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                n = Integer.parseInt(br.readLine());
                bw.append(Integer.toString(readMatrix(n, br)));
                bw.newLine();
            }
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static int readMatrix(int n, BufferedReader br) {
        String[] matrix = new String[n];
        for (int i = 0; i < n; i++) {
            try {
                matrix[i] = br.readLine();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
        return maxSquare(matrix, n);
    }

    public static int maxSquare(String[] matrix, int n) {
        int max = 0;
        int[][] matrixSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrixSquare[i][0] = matrix[i].charAt(0) == ('#') ? 0 : 1;
            matrixSquare[0][i] = matrix[0].charAt(i) == ('#') ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i].charAt(j) == ('.')) {
                    matrixSquare[i][j] = (Math.min(Math.min(matrixSquare[i][j - 1], matrixSquare[i - 1][j]),
                            matrixSquare[i - 1][j - 1])) + 1;
                    max = Math.max(max, matrixSquare[i][j]);
                } else if (matrix[i].charAt(j) == ('#')) {
                    matrixSquare[i][j] = 0;
                }
            }
        }
        return max;
    }
}
