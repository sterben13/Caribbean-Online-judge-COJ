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
public class DivisorsII3783 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String[] line;
        while (t-- > 0) {
            line = br.readLine().split("\\s+");
            System.out.println(divSum(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
    }

    private static int divSum(int num, int k) {
        if (k == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i)) {
                    if (i % k != 0) {
                        result += i;
                    }
                } else {
                    if (i % k != 0) {
                        result += i;
                    }
                    if ((num / i) % k != 0) {
                        result += (num / i);
                    }
                }
            }
        }
        return result;
    }
}
