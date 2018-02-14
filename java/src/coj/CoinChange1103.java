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
import java.util.Arrays;

/**
 *
 * @author iromeroga
 */
public class CoinChange1103 {

    public static final int[] coin = {50, 25, 10, 5, 1};

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int number;
        try {
            while (br.ready()) {
                number = Integer.parseInt(br.readLine());
                bw.append(String.valueOf(count2(coin, coin.length, number)));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        //System.out.println(count2(coin, coin.length, 26));
    }

    public static long count(int s[], int m, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (m <= 0 && n >= 1) {
            return 0;
        }
        return count(s, m - 1, n) + count(s, m, n - s[m - 1]);
    }

    public static long count2(int s[], int m, int n) {
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = s[i]; j <= n; j++) {
                table[j] += table[j - s[i]];
            }
        }
        return table[n];
    }
}
