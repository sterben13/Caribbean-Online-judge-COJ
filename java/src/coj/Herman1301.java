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
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 *
 * @author iromeroga
 */
public class Herman1301 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        nf.setRoundingMode(RoundingMode.DOWN);
        
        double PI = 3.141592653589793;
        double r = Double.parseDouble(br.readLine());
        
        System.out.println(nf.format(PI * r * r).replace(",", ""));
        System.out.printf("%.4f\n", 2 * (r * r));
    }

}
