/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=3333
* Problem: 3333 - Suma Básica
* Descripcion:
* Naebbirac tiene una secuencia S que consiste en N enteros positivos; los elementos en esta secuencia están convenientemente
* numerados, de izquierda a derecha, entre 1 y N. Definimos la función F(i, j) [i <= j] como la suma de los elementos entre 
* i y j (i.e. F(i, j) = S_i + S_(i+1) + ... + S_(j-1) + S_j). Por ejemplo, F(4, 4) = S_4, F(7, 8) = S_7 + S_8 y F(2, 6) = 
* S_2 + S_3 + S_4 + S_5 + S_6.
* La tarea en este problema consiste en ejecutar la función F múltiples veces, y calcular el resultado.
**/
package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class SumaBasica3333 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static int[] arr;
    private static int[] st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split("\\s+");
        int q = Integer.parseInt(br.readLine());
        init(line);
        while (q-- > 0) {
            line = br.readLine().split("\\s+");
            bw.append(sum(0, arr.length - 1, Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1, 0) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void init(String[] arrS) {
        arr = new int[arrS.length];
        for (int i = 0; i < arrS.length; i++) {
            arr[i] = Integer.parseInt(arrS[i]);
        }
        int x = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int max_l = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_l];
        builtTree(0, arr.length - 1, 0);
    }

    private static int builtTree(int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int m = mid(ss, se);
        st[si] = builtTree(ss, m, si * 2 + 1) + builtTree(m + 1, se, si * 2 + 2);
        return st[si];
    }

    public static long sum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        if (se < qs || ss > qe) {
            return 0;
        }

        int mid = mid(ss, se);
        return sum(ss, mid, qs, qe, 2 * si + 1)
                + sum(mid + 1, se, qs, qe, 2 * si + 2);
    }

    private static int mid(int ss, int se) {
        return ss + (se - ss) / 2;
    }
}
