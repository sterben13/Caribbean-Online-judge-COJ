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
public class PerfectPthPowers1013 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        long x;
        while (true) {
            x = Long.parseLong(br.readLine());
            if (x == 0) {
                break;
            }
            bw.append(power(Math.abs(x))+"\n");
        }
        bw.flush();
        bw.close();
    }

    static long power(long n) {
        for (long x = 2; x <= Math.sqrt(n)+1; x++) {
            long y = 2;
            double p = Math.pow(x, y);
            while (p <= n && p > 0) {
                if (p == n) {
                    return y;
                }
                y++;
                p = Math.pow(x, y);
            }
        }
        return 1;
    }

}
