/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1651
* Problem: 
* Descripción
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
public class AgainMakingQueriesI1830 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static long[] arr;
    private static long[] st;
    private static final int mod = 10000;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split("\\s+");
        arr = new long[Integer.parseInt(line[0]) + 2];
        int u = Integer.parseInt(line[1]);
        int q = Integer.parseInt(line[2]);
        for (int i = 0; i < u; i++) {
            line = br.readLine().split("\\s+");
            update(Integer.parseInt(line[0]), Long.parseLong(line[1]));
        }
        init();
//        for (int i = 1; i < arr.length; i++) {
//            arr[i] = ((arr[i] % mod) + (arr[i - 1] % mod)) % mod;
//        }
        for (int i = 0; i < q; i++) {
            line = br.readLine().split("\\s+");
            //System.out.println(arr[Integer.parseInt(line[1])] - arr[Integer.parseInt(line[0]) - 1]);
            System.out.println(sum(0, arr.length - 1, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0));
        }
    }

    private static void update(int i, long k) {
        arr[i - 1] = ((arr[i - 1] % mod) + (k % mod)) % mod;
        arr[i] = ((arr[i] % mod) + ((k + 1) % mod));
        arr[i + 1] = ((arr[i + 1] % mod) + (k % mod)) % mod;
    }

    private static void init() {
        int x = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int max = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max];
        builtTree(arr, 0, arr.length - 1, 0);
    }

    public static long builtTree(long[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss] % mod;
        }
        int mid = getMid(ss, se);
        st[si] = (builtTree(arr, ss, mid, si * 2 + 1) % mod)
                + (builtTree(arr, mid + 1, se, si * 2 + 2) % mod);
        return st[si];
    }

    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static long sum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si] % mod;
        }

        if (se < qs || ss > qe) {
            return 0;
        }

        int mid = getMid(ss, se);
        return ((sum(ss, mid, qs, qe, 2 * si + 1) % mod)
                + (sum(mid + 1, se, qs, qe, 2 * si + 2) % mod));
    }

}
