/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author iromeroga
 */
public class HowManyKeys2951 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        Set<String> set = new HashSet<>();
        try {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                set.add(sortingString(br.readLine()));
            }
            bw.append(String.valueOf(set.size()));
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
    public static String sortingString(String s){
        char [] chain = s.toCharArray();
        Arrays.sort(chain);
        return new String(chain);
    }
}
