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
public class SmallerPerimeter1678 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] line;
        long a, b, c, min = Long.MAX_VALUE;
        while (n-- > 0) {
            line = br.readLine().split("\\s+");
            a = Long.parseLong(line[0]);
            b = Long.parseLong(line[1]);
            c = Long.parseLong(line[2]);
            if (isTriangle(a, b, c)) {
                min = Math.min(min, (a + b + c));
            }
        }
        System.out.println(min);
    }

    private static boolean isTriangle(long a, long b, long c) {
        return (a + b) > c && (a + c) > b && (c + b) > a;
    }
}
