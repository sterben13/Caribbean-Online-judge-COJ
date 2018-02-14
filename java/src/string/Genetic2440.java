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

/**
 *
 * @author iromeroga
 */
public class Genetic2440 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        String [] line; 
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {            
            line = br.readLine().split("\\s+");
            if(line[0].contains("T")){
                if(line[0].contains(line[1])){
                    bw.append("Y\n");
                }else{
                    bw.append("N\n");
                }
            }else{
                bw.append("N\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
