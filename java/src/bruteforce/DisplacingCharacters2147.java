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
public class DisplacingCharacters2147 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter ow = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(ow);

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String [] line;
        while (n-->0) {            
            line = br.readLine().split("\\s+");
            rotate(line[0], Integer.parseInt(line[1]));
        }
        bw.flush();
        bw.close();
    }

    private static void rotate(String s, int k) throws IOException {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            bw.append(s.charAt((i+(l-(k%l)))%l));
        }
        bw.newLine();
    }
}
