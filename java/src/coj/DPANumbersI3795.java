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
public class DPANumbersI3795 {
    
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n, sum;
        while (t-- > 0) {            
            n = Integer.parseInt(br.readLine());
            sum = divSum(n);
            if (n > sum) {
                bw.append("deficient");
            } else if (n == sum) {
                bw.append("perfect");
            } else if (n < sum) {
                bw.append("abundant");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    private static int divSum(int num) {
        int result = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i)) {
                    result += i;
                } else {
                    result += (i + num / i);
                }
            }
        }
        return (result + 1);
    }
}
