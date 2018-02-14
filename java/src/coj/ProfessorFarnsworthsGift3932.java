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
import java.util.Arrays;

/**
 *
 * @author iromeroga
 */
public class ProfessorFarnsworthsGift3932 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int t;
        String line;
        char[] number;
        try {
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                line = br.readLine();
                if (line.equals("0")) {
                    bw.append("0");
                    bw.newLine();
                } else if (line.charAt(0) == '-') {
                    number = line.substring(1).toCharArray();
                    Arrays.sort(number);
                    bw.append("-");
                    for (int i = number.length - 1; i >= 0; i--) {
                        bw.append(number[i]);
                    }
                    bw.newLine();
                } else {
                    number = line.toCharArray();
                    Arrays.sort(number);
                    if (number[0] == '0') {
                        for (int i = 0; i < number.length; i++) {
                            if (number[i] != '0') {
                                number[0] = number[i];
                                number[i] = '0';
                                break;
                            }
                        }
                    }
                    for (int i = 0; i < number.length; i++) {
                        bw.append(number[i]);
                    }
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
