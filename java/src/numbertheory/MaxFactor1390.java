/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class MaxFactor1390 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cow = 0, prime, res = 0;
        int max = Integer.MIN_VALUE;
        while (n-- > 0) {
            cow = Integer.parseInt(br.readLine());
            if (cow == 1) {
                res = 0;
            } else {
                prime = maxPrimeFactor(cow);
                if (max < prime) {
                    max = prime;
                    res = cow;
                }
            }
        }
        bw.append(res + "\n");
        bw.flush();
        bw.close();
    }

    private static int maxPrimeFactor(int cow) {
        int maxPrime = -1;
        while (cow % 2 == 0) {
            maxPrime = 2;
            cow >>= 1;
        }
        for (int i = 3; i <= Math.sqrt(cow); i += 2) {
            while (cow % i == 0) {
                maxPrime = i;
                cow /= i;
            }
        }
        if (cow > 2) {
            maxPrime = cow;
        }
        return maxPrime;
    }

}
