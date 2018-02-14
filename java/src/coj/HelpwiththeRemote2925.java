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
public class HelpwiththeRemote2925 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        String[] line;
        int a, b;
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                line = br.readLine().split("\\s+");
                a = Integer.parseInt(line[0]);
                b = Integer.parseInt(line[1]);
                if (a < b) {
                    bw.append(Integer.toString((b - a)));
                } else {
                    int cont = 0;
                    while (a > b) {
                        a /= 2;
                        cont++;
                    }
                    bw.append(Integer.toString((cont + (b - a))));
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
