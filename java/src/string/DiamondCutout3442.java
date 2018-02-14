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
import java.util.Arrays;

/**
 *
 * @author iromeroga
 */
public class DiamondCutout3442 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        char[] line = br.readLine().toCharArray();
        int t = line.length;
        char[] space = new char[t];
        if ((t & 1) != 0) {
            char[][] diamond = new char[t][t];
            Arrays.fill(space, ' ');
            diamond[0] = diamond[t - 1] = line;
            int med = t / 2;
            for (int i = 1, l = t - 2; i < line.length / 2 + 1; i++, l--) { 
                for (int j = 0, k = t - 1; j < med; j++, k--) {
                    diamond[i][j] = line[j];
                    diamond[i][k] = line[k];
                    diamond[l][j] = line[j];
                    diamond[l][k] = line[k];
                }
                med--;
            }
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    bw.append(diamond[i][j]);
                }
                bw.newLine();
            }
        } else {
            bw.append("error");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
