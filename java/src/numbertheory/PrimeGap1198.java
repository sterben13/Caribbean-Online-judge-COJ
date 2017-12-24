/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1198
* Problem: 1198 - Prime Gap
* Descripcion: The sequence of n-1 consecutive composite positives numbers (whole numbers that 
* are not prime or equal to 1) found between two consecutive primes p and p+n is called prime gap
* of length n. For example, do 24, 25, 26, 27, 28? between 23 and 29 is a prime gap of length 6. 
* Your mission is to write a program to compute given a positive integer k the length of the prime gap
* containing k. For convenience, the length is considered 0 if no breach of primes contains k.
**/

package numbertheory;

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
public class PrimeGap1198 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static boolean[] primes;

    public static void main(String[] args) throws IOException {
        int k;
        sieve(10000000);
        while (true) {
            k = Integer.parseInt(br.readLine());
            if (k == 0) {
                break;
            }
            if (primes[k]) {
                bw.append("0\n");
            } else {
                int next = 0, before = 0;
                for (int i = k; i < primes.length; i++) {
                    if (primes[i]) {
                        next = i;
                        break;
                    }
                }
                for (int i = k; i > 1; i--) {
                    if (primes[i]) {
                        before = i;
                        break;
                    }
                }
                bw.append((next - before)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void sieve(int n) {
        primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }
}
