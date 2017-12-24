/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=3274
* Problem: 3274 - How Many Primes Divide the Number
* Descripcion: Given a positive integer number N, could you find how many prime numbers divide the number N such that they are between 2 and N inclusive?
**/
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author iromeroga
 */
public class HowManyPrimesDividetheNumber3274 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static boolean[] primes;
    private static ArrayList<Integer> primesInt;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        sieve(10000);
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            if (primes[n]) {
                System.out.println("1");
            } else {
                int  count = 0;
                for (int i = 0; i < primesInt.size(); i++) {
                    if (primesInt.get(i) > n) {
                        break;
                    }
                    if (n % primesInt.get(i) == 0) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }

    private static void sieve(int n) {
        primes = new boolean[n + 1];
        primesInt = new ArrayList<>();
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 0; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                primesInt.add(i);
            }
        }
    }
}
