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
public class AboutDogsandaPostman1236 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int a, b, c, d, p, m, g;
        String[] line = br.readLine().split("\\s+");
        a = Integer.parseInt(line[0]);
        b = Integer.parseInt(line[1]);
        c = Integer.parseInt(line[2]);
        d = Integer.parseInt(line[3]);
        line = br.readLine().split("\\s+");
        p = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        g = Integer.parseInt(line[2]);
        System.out.println(resul(dog(a, b, p), dog(c, d, p)));
        System.out.println(resul(dog(a, b, m), dog(c, d, m)));
        System.out.println(resul(dog(a, b, g), dog(c, d, g)));
    }

    private static int dog(int a, int c, int man) {
        int mod = man % (a + c);
        return (mod >= 1 && mod <= a) ? 1 : 0;
    }

    private static String resul(int a, int b) {
        int r = a + b;
        return (r == 2) ? "both" : (r == 1) ? "one" : "none";
    }
}
