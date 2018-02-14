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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author iromeroga
 */
public class CountingSubstrings3939 {
    
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < line.length(); i++) {
            for (int j = i+1; j <= line.length(); j++) {
               set.add(line.substring(i,j));
            }
        }
        bw.append(set.size()+"\n");
        bw.flush();
        bw.close();
    }
    
}
