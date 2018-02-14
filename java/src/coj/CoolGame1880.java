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
public class CoolGame1880 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE);
        int t = Integer.parseInt(br.readLine());
        int n;
        String[] line;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            line = new String[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                line[i] = br.readLine();
            }
            boolean inc = false, dec = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (line[i].charAt(i) > line[i + n].charAt(i)) {
                        dec = true;
                    } else {
                        inc = true;
                    }
                }
            }
            if(dec&&inc){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
