/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticalgebra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class TriangleofPrimes3367 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    private static boolean[] prime;

    public static void main(String[] args) throws IOException {
        int l, r;
        long suma;
        sieveOfEratosthenes(1000000);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            r = (n * (n + 1)) / 2;
            l = (r - n) + 1;
            suma = 0;
            for (int i = l; i <= r; i++) {
                if (prime[i]) {
                    suma += i;
                }
            }
            bw.append(suma + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int n) {
        prime = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
    }
}
