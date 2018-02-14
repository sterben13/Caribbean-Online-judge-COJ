/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class AVION2655 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        boolean p = true;
        for (int i = 1; i <= 5; i++) {
            if (br.readLine().contains("FBI")) {
                bw.append(i + " ");
                p = false;
            }
        }
        if (p) {
            bw.append("HE GOT AWAY!");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
