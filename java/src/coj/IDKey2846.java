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
public class IDKey2846 {
    
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        String line;
        try{
            int t = Integer.parseInt(br.readLine());
            while(t-->0){
                line = br.readLine();
                bw.append(processThree(processOne(line), processTwo(line.substring(10))));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        System.out.println();
    }
    
    public static int processOne(String num){
        int sum =0;
        for (int i = 0; i < num.length(); i++) {
            sum+=num.charAt(i)-'0';
        }
        return sum;
    }
    
    public static int processTwo(String num){
        return Integer.parseInt(num)*10;
    }
    
    public static String processThree(int a, int b){
        int sum = a+b;
        if(sum<1000){
            return String.valueOf(sum+1000);
        }else if(sum>=10000){
            return String.valueOf(sum).substring(1);
        }else{
            return String.valueOf(sum);
        }
    }
}
