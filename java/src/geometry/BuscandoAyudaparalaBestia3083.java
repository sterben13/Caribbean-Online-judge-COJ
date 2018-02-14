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
public class BuscandoAyudaparalaBestia3083 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        double min = Double.MAX_VALUE;
        double d;
        String[] line;
        String name="";
        while (t-- > 0) {
            line = br.readLine().split("\\s+");
            d = dist(Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            if (min > d) {
                {
                    min = d;
                    name = line[0];
                }
            }
        }
        bw.append(name);
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static double dist(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
