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
public class CipheringPrograms1006 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    private static int index;
    private static char[] resp;

    public static void main(String[] args) throws IOException {
        char[] line;
        while (br.ready()) {
            line = br.readLine().toCharArray();
            index = 0;
            resp = new char[line.length];
            cipher(line, 0, line.length - 1);
            for (int i = 0; i < resp.length; i++) {
                if (Character.isAlphabetic(resp[i])) {
                    switch (resp[i]) {
                        case 'a':
                            bw.append('z');
                            break;
                        case 'A':
                            bw.append('Z');
                            break;
                        default:
                            bw.append((char) (resp[i] - 1));
                    }
                } else {
                    bw.append(resp[i]);
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void cipher(char[] line, int low, int high) {
        if (high < low) {
            return;
        }
        int mid = (low + high) / 2;
        resp[mid] = line[index++];
        cipher(line, low, mid - 1);
        cipher(line, mid + 1, high);
    }
}
