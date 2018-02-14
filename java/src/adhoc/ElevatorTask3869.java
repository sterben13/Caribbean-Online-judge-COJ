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

/**
 *
 * @author iromeroga
 */
public class ElevatorTask3869 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int t = Integer.parseInt(br.readLine());
        int floor = Integer.parseInt(br.readLine());
        int floor2;
        int suma = Math.abs(1-floor);
        t--;
        while (t-->0) {            
            floor2 = Integer.parseInt(br.readLine());
            suma += Math.abs(floor2-floor);
            floor= floor2;
        }
        suma+=Math.abs(floor-1);
        bw.append(String.valueOf(suma));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
