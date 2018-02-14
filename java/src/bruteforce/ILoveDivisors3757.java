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
public class ILoveDivisors3757 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            div(n);
        }
        bw.flush();
        bw.close();
    }

    public static void div(int n) throws IOException {
        int p = 0, im = 1;
        if ((n & 1) == 0) {
            p++;
        } else {
            im++;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    if ((i & 1) == 0) {
                        p++;
                    } else {
                        im++;
                    }
                } else {
                    if ((i & 1) == 0) {
                        p++;
                    } else {
                        im++;
                    }
                    if (((n / i) & 1) == 0) {
                        p++;
                    } else {
                        im++;
                    }
                }
            }
        }
        bw.append("P: "+p);
        bw.append(" ");
        bw.append("I: "+im);
        bw.newLine();
    }
}
