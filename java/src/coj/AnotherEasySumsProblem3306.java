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
public class AnotherEasySumsProblem3306 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        String [] line = br.readLine().split("\\s+");
        int a = Integer.parseInt(line[0], 8)+Integer.parseInt(line[1], 8);
        bw.append("0x"+Integer.toHexString(a));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
