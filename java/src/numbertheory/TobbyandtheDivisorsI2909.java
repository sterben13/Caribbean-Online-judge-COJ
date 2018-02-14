/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class TobbyandtheDivisorsI2909 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static final int[] div = new int[2501];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        fillArray();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            bw.append(div[n] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void fillArray() {
        int max = 1;
        int p = 1;
        div[1] = 1;
        int c;
        for (int i = 2; i < 2501; i++) {
            c = countDiv(i);
            if(max<c){
                p=i;
                max=c;
            }
            div[i] = p;
        }
    }

    private static int countDiv(int n) {
        int count = 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += (n / i == i) ? 1 : 2;
            }
        }
        return count;
    }
}
