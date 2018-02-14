/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class ElCastigodeCenicienta3086 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static final double PI = Math.acos(0) * 2;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int r;
        double r1, r2, h, v, vCono;
        String[] line;
        while (t-- > 0) {
            line = br.readLine().split("\\s+");
            r1 = Double.parseDouble(line[0]);
            r2 = Double.parseDouble(line[1]);
            h = Double.parseDouble(line[2]);
            v = Double.parseDouble(line[3]);
            vCono = ((h * Math.PI) / 3) * (Math.pow(r2, 2) + Math.pow(r1, 2) + (r2 * r1));
            r = cubos(v, vCono);
            r += cubos(v, vCono);
            bw.append(r + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int cubos(double v, double vCono) {
        int r;
        if (v <= vCono) {
            return 1;
        } else {
            r = (int) (v / vCono);
            r += ((v % vCono)==0)?0:1;
            return r;
        }
    }
}
