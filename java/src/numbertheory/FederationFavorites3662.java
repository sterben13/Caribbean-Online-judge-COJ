/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=3662
* Problem: 3662 - Federation Favorites
* Descripcion: In route to Rigel 7, Chief Engineer Geordi Laforge and Data were discussing favorite numbers.
* Geordi exclaimed he preferred Narcissistic Numbers: those numbers whose value is the same as the sum of the
* digits of that number, where each digit is raised to the power of the number of digits in the number.
* Data agreed that Narcissistic Numbers were interesting, but not as good as his favorite: Perfect Numbers.
* Geordi had never heard of a Perfect Number, so Data elaborated, “A positive integer is said to be Perfect
* if it is equal to the sum of its positive divisors less than itself. For example, 6 is Perfect 
* because 6 = 1 + 2 + 3."
* Geordi began thinking about an algorithm to determine if a number was Perfect, but did not have the raw
* computing ability of Data. He needs a program to determine if a given number is Perfect.
* Help Geordi write that program.
**/
package numbertheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author iromeroga
 */
public class FederationFavorites3662 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n < 0) {
                break;
            }
            bw.append(isPerfect(n));
        }
        bw.flush();
        bw.close();
    }

    private static StringBuilder isPerfect(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    sum += i;
                    arr.add(i);
                } else {
                    sum += (i + (n / i));
                    arr.add(i);
                    arr.add(n / i);
                }
            }
        }
        if (sum + 1 == n) {
            sb.append("= 1");
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                sb.append(" + ");
                sb.append(arr.get(i));
            }
            sb.append("\n");
        } else {
            sb.append("is NOT perfect.");
            sb.append("\n");
        }
        return sb;
    }
}
