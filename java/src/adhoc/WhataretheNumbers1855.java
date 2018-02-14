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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author iromeroga
 */
public class WhataretheNumbers1855 {
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        Set<Integer> s = new TreeSet();
        int t = Integer.parseInt(br.readLine());
        int n, k;
        boolean imp;
        while (t-->0) {            
            n = Integer.parseInt(br.readLine());
            imp=true;
            s.clear();
            while (n-->0) {                
                k = Integer.parseInt(br.readLine());
                if(s.contains(k)){
                    bw.append(k+"");
                    bw.newLine();
                    imp=false;
                }else{
                    s.add(k);
                }
            }
            if(imp){
                bw.append("Not found!");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
