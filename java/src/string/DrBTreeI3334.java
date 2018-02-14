package string;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iromeroga
 */
public class DrBTreeI3334 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int l = Integer.parseInt(br.readLine());
        String p = br.readLine();
        int j = 0;
        boolean imp = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==p.charAt(j)){
                j++;
                if(j==l){
                    imp = true;
                    j=0;
                    n-=l;
                }
            }
        }
        bw.append(n!=s.length()?String.valueOf(n):"-1");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
