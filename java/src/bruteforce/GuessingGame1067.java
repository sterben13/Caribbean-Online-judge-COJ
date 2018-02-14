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
public class GuessingGame1067 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n, l = 0, r = 11;
        String line;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            line = br.readLine();
            if (line.endsWith("h")) {
                if (n < r) {
                    r = n;
                }
            } else if (line.endsWith("w")) {
                if (n > l) {
                    l = n;
                }
            } else if (line.endsWith("n")) {
                if (n > l && n < r) {
                    bw.append("Stan may be honest\n");

                } else {
                    bw.append("Stan is dishonest\n");
                }
                l = 0;
                r = 11;
            }
        }
        bw.flush();
        bw.close();
    }
}
