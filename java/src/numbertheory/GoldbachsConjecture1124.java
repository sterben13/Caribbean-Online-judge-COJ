/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1124
* Problem: 1124 - Goldbach's Conjecture
* Descripcion: In 1742, Christian Goldbach, a German amateur mathematician, sent a letter to Leonhard Euler
* in which he made the following conjecture: Every even number greater than 4 can be written as the sum of
* two odd prime numbers. For example: 8 = 3 + 5. Both 3 and 5 are odd prime numbers. 20 = 3 + 17 = 7 + 13.
* 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23. Today it is still unproven whether the conjecture is right. 
* (Oh wait, I have the proof of course, but it is too long to write it on the margin of this page.) Anyway,
* your task is now to verify Goldbach's conjecture for all even numbers less than a million.
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
public class GoldbachsConjecture1124 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static boolean[] primes;
    private static ArrayList<Integer> primesInt;

    public static void main(String[] args) throws IOException {
        int n;
        sieve(10000000);
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            findPrimes(n);
        }
    }

    private static void findPrimes(int n) {
        if (n <= 2 || n % 2 != 0) {
            System.out.println("Goldbach's conjecture is wrong.");
        } else {
            for (int i = 0; i <= n / 2; i++) {
                int diff = n - primesInt.get(i);
                if (primes[diff]) {
                    System.out.println(n + " = " + primesInt.get(i) + " + " + diff);
                    return;
                }
            }
        }
    }

    private static void sieve(int n) {
        primes = new boolean[n + 1];
        primesInt = new ArrayList<>();
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                primesInt.add(i);
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
