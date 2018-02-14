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
public class SideoftheRhombus1214 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        double a, s, side;
        String[] line;
        while (t-- > 0) {
            line = br.readLine().split("\\s+");
            a= Double.parseDouble(line[0]);
            s= Double.parseDouble(line[1]);
            side=side(a,s);
            System.out.printf("%.2f\n",side);
        }
    }

    private static double side(double a, double s) {
        return Math.sqrt(Math.pow(s, 2)-(4*a))/2;
    }
}
