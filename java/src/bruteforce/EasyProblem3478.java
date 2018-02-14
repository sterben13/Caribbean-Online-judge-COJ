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
public class EasyProblem3478 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        StringBuilder binary = new StringBuilder(br.readLine());
        complement(binary);
        convertOctal(binary);
        bw.flush();
        bw.close();
    }

    private static void complement(StringBuilder sb) {
        switch (sb.length() % 3) {
            case 1:
                sb.insert(0, "00");
                break;
            case 2:
                sb.insert(0, "0");
                break;
            default:
                break;
        }
    }

    private static void convertOctal(StringBuilder binary) throws IOException {
        int i = 0, j = 3;
        while (j <= binary.length()) {
            bw.append(octal(binary.substring(i, j)));
            i = j;
            j = i + 3;
        }
        bw.newLine();
    }

    private static String octal(String s) {
        switch (s) {
            case "000":
                return "0";
            case "001":
                return "1";
            case "010":
                return "2";
            case "011":
                return "3";
            case "100":
                return "4";
            case "101":
                return "5";
            case "110":
                return "6";
            case "111":
                return "7";
            default:
                return "";
        }
    }
}
