/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1651
* Problem: 
* Descripción
* 
* You are given a list of (1 <= N <= 10^4) integer numbers between 1 and 10^3, and 
* you must find as fast as you can the minimum number between any range [A,B] with 
* (1 <= A,B <= N). Remember, the time is important here. Perhaps this software, is 
* an vital part of an powerfull invention.
*
* Especificación de entrada.
*
* The first line, the number N. 
* On the second line there are N integer numbers Ni (they are space-separated).
* The third line, one integer number Q: the number of queries to be made.
* On the following Q lines, there are two integer numbers A and B. 
* The number of queries Q will be at most 500000.
* Especificación de salida.
*
* Q lines, with one number per line (the answer for each query).
* Solution: se utilizo arboles de segmentos configurado para obtener el minimo de 
* entre un rango dado del arreglo.
**/

package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class FindingMinimum1651 {

    private static long[] st;

    public static void init(long[] arr) {
        int n = arr.length;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max_size];
        builtTree(arr, 0, n - 1, 0);
    }

    private static long builtTree(long[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        int mid = getMid(ss, se);
        st[si] = minVal(builtTree(arr, ss, mid, si * 2 + 1), builtTree(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    private static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    private static long minVal(long x, long y) {
        return (x < y) ? x : y;
    }

    private static long min(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        if (se < qs || ss > qe) {
            return Integer.MAX_VALUE;
        }

        int mid = getMid(ss, se);
        return minVal(min(ss, mid, qs, qe, 2 * si + 1), min(mid + 1, se, qs, qe, 2 * si + 2));
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int n, q, a, b;
        long[] ni;
        String[] line;
        try {
            n = Integer.parseInt(br.readLine());
            line = br.readLine().split(Pattern.quote(" "));
            ni = new long[n];
            for (int i = 0; i < line.length; i++) {
                ni[i] = Long.parseLong(line[i]);
            }
            init(ni);
            q = Integer.parseInt(br.readLine());
            while (q-- > 0) {
                line = br.readLine().split(Pattern.quote(" "));
                a = Integer.parseInt(line[0])-1;
                b = Integer.parseInt(line[1])-1;
                if(a<b){
                    System.out.println(min(0, n - 1, a, b, 0));
                }else{
                    System.out.println(min(0, n - 1, b, a, 0));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FindingMinimum1651.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}