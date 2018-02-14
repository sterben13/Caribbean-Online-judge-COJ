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
import java.util.Arrays;

/**
 *
 * @author iromeroga
 */
public class BountyHunter1219 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int t, b, a, result;
        String[] line;
        int[] arr;
        try {
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                line = br.readLine().split("\\s+");
                b = Integer.parseInt(line[0]);
                a = Integer.parseInt(line[1]);
                arr = new int[a];
                for (int i = 0; i < a; i++) {
                    line = br.readLine().split("\\s+");
                    arr[i] = Integer.parseInt(line[0]);
                }
                Arrays.sort(arr);
                result = 0;
                for (int i = arr.length - 1; b != 0; i--) {
                    result+=arr[i];
                    b--;
                }
                bw.append(Integer.toString(result));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
