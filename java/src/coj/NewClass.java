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
public class NewClass {
    
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int [] arr;
        String [] line;
        while (t-->0) {            
            arr = new int[Integer.parseInt(br.readLine())];
            line = br.readLine().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                arr[i]= Integer.parseInt(line[i]);
            }
            System.out.println("Optimal train swapping takes "+bubbleSort(arr)+" swaps.");
        }
        
    }

    private static int bubbleSort(int arr[]) {
        int n = arr.length;
        int cont = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    cont++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return cont;
    }
}
