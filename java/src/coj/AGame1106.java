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
public class AGame1106 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int p1 = 0, p2 = 0;
        int t = Integer.parseInt(br.readLine());
        int n;
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            if ((i & 1) == 0) {
                p1 += n;
            } else {
                p2 += n;
            }
        }
        bw.append((p1 > p2) ? p1 + " " + p2 : p2 + " " + p1);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
