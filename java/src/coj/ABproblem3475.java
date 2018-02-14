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
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author iromeroga
 */
public class ABproblem3475 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split("\\s+");
        BigInteger bg = new BigInteger("0");
        
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        bw.append(Long.toString(f(a, b)));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static long f(int a, int b) {
        double name = ((a * b) * (Math.cos(2 * a) - 1) / (2 * Math.cos(2 * a))) + ((a * b) * ((Math.cos(2 * a) + 1) / (2 * Math.cos(2 * a))));
        return (long) name;
    }

}
