/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class MathTable2373 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static double a, b, c, d, max;
    private static int r = 0, aux=1;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split("\\s+");
        a = Double.parseDouble(line[0]);
        b = Double.parseDouble(line[1]);
        line = br.readLine().split("\\s+");
        c = Double.parseDouble(line[0]);
        d = Double.parseDouble(line[1]);
        max = operation(a, b, c, d);
        System.out.println(max);
        rotation(max, operation(c, a, d, b));
        System.out.println(max);
        rotation(max, operation(d, c, b, a));
        System.out.println(max);
        rotation(max, operation(b, d, a, c));
        System.out.println(max);
        System.out.println(r);
    //System.out.println("4");
    }

    private static double operation(double a, double b, double c, double d) {
//        try {
            return (a / b) + (c / d);
//        } catch (ArithmeticException e) {
//            return 0;
//        }
    }

    private static void rotation(double max, double operation) {
        if(max<operation){
            max=operation;
            r=aux;
        }
        aux++;
    }
}
