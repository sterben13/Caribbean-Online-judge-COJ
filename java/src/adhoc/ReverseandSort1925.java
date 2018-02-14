/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author iromeroga
 */
public class ReverseandSort1925 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static final ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String line = br.readLine()+"\n";
        while (br.ready()) {
            line += br.readLine()+"\n";
        }
        line.split("\n");
        
    }

    public static void process(String[] arrStrings) {
        String[] aux;
        StringBuilder sb = new StringBuilder();
        for (String arrString : arrStrings) {
            aux = arrString.split("\\s+");
            for (String aux1 : aux) {
                sb = new StringBuilder(aux1);
                arr.add(Long.parseLong(sb.reverse().toString()));
            }
        }
    }
}
