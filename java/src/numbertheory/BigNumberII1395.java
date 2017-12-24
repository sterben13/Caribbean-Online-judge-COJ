/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1395
* Problem: 1395 - Big Number II
* Descripcion: In many applications very large integers numbers are required. Some of these applications
* are using keys for secure transmission of data, encryption, etc. In this problem you are given a number,
* you have to determine the number of digits in the factorial of the number.
**/
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class BigNumberII1395 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static double[] arr = new double[10000001];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        process();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            bw.append(sumDigits(n) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static long sumDigits(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        return (long) Math.floor(arr[n]) + 1;
    }

    private static void process() {
        double sum = 0;
        for (int i = 2; i <= 10000000; i++) {
            sum += Math.log10(i);
            arr[i] = sum;
        }
    }
}
