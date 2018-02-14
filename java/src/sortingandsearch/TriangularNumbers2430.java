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

/**
 *
 * @author iromeroga
 */
public class TriangularNumbers2430 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int number;
        while (true) {
            number = Integer.parseInt(br.readLine());
            if(number==0){
                break;
            }
            int v = (int) Math.pow((2 * number), 0.5);
            if((v*(v+1))==2*number){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
