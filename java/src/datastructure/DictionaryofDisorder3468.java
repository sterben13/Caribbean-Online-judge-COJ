/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author iromeroga
 */
public class DictionaryofDisorder3468 {
    
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        char [] line;
        String orden;
        while (n-- > 0) {            
            line = br.readLine().toCharArray();
            Arrays.sort(line);
            orden = new String(line);
            if(map.containsKey(orden)){
                map.put(orden, new Integer(map.get(orden)+1));
            }else{
                map.put(orden, 0);
            }
            bw.append(map.get(orden)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
