/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=2272
* Problem: 2272 - Next Prime
* Descripcion: Given an integer n, with 0 <= n <= 4*10^9, your task is to find the smallest prime
* number which is not less than n.
**/
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 *
 * @author iromeroga
 */
public class NextPrime2272 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            BigInteger bi = new BigInteger(br.readLine());
            if (bi.isProbablePrime(1)) {
                bw.append(bi.toString());
            } else {
                bw.append(bi.nextProbablePrime().toString());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
